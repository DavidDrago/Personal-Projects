using GameStore.API.Data;
using GameStore.API.Dtos;
using GameStore.API.Models;
using Microsoft.EntityFrameworkCore;

namespace GameStore.API.EndPoints;

public static class GamesEndPoints
{
    const string GetEndpointGameName = "GetGame";

    private static readonly List<GameDto> games =
    [
        new (1, "Street Fighter II", "Fighting", 19.99M, new DateOnly(1992, 7, 15)),
        new (2, "Genshin Impact", "Action/Role-Playing", 0, new DateOnly(2020, 9, 28)),
        new (3, "Crimson Desert", "Action/Adventure", 59.19M, new DateOnly(2026, 3, 19))
    ];

    public static void MapGamesEndPoints(this WebApplication app)
    {
        var group = app.MapGroup("/games");

        app.MapGet("/", () => "Hello World!");

        // GET /games
        group.MapGet("/", async (GameStoreContext dbContext) 
            => await dbContext.Games
                        // .Include(game => game.Genre)
                        .Select(game => new GameDto(
                            game.Id,
                            game.Name,
                            game.Genre!.Name,
                            game.Price,
                            game.ReleaseDate
                        ))
                        .AsNoTracking()
                        .ToListAsync());

        //GET /games/id 
        group.MapGet("/{id}", async (int id, GameStoreContext dbContext) => {
            var game = await dbContext.Games.FindAsync(id);
            return game is null ? Results.NotFound() : Results.Ok(
                new GameDetailsDto(
                    game.Id,
                    game.Name,
                    game.GenreId,
                    game.Price,
                    game.ReleaseDate
                )
            );
        })
        .WithName(GetEndpointGameName);

        //POST /games
        group.MapPost("/", async (CreateGameDto newGame, GameStoreContext dbContext) =>
        {
            /*GameDto game = new(
                games.Count + 1,
                newGame.Name,
                newGame.Genre,
                newGame.Price,
                newGame.ReleaseDate
            );
            games.Add(game);*/
            
            Game game = new()
            {
                Name = newGame.Name,
                GenreId = newGame.GenreId,
                Price = newGame.Price,
                ReleaseDate = newGame.ReleaseDate
            };
 
            dbContext.Games.Add(game);
            await dbContext.SaveChangesAsync();

            GameDetailsDto gameDto = new(
                game.Id,
                game.Name,
                game.GenreId,
                game.Price,
                game.ReleaseDate
            );

            return Results.CreatedAtRoute(GetEndpointGameName, new {id = gameDto.Id}, gameDto);
        });

        //PUT /games/id
        group.MapPut("/{id}", async (
            int id, 
            UpdateGameDto updateGame,
            GameStoreContext dbContext) =>
        {
            var existingGame = await dbContext.Games.FindAsync(id);

            if(existingGame is null)
            {
                return Results.NotFound();
            }

            existingGame.Name = updateGame.Name;
            existingGame.GenreId = updateGame.GenreId;
            existingGame.Price = updateGame.Price;
            existingGame.ReleaseDate = updateGame.ReleaseDate;

            await dbContext.SaveChangesAsync();

            return Results.NoContent();
        });

        //DELETE /games/id
        group.MapDelete("/{id}", async (int id, GameStoreContext dbContext) =>
        {
            await dbContext.Games
                            .Where(game => game.Id == id)
                            .ExecuteDeleteAsync();
                            
            // games.RemoveAll(game => game.Id == id);

            return Results.NoContent();
        });
    }
}
