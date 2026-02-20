using GameStore.API.Dtos;

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
        group.MapGet("/", () => games);

        //GET /games/id
        group.MapGet("/{id}", (int id) => {
            var game = games.Find(games => games.Id == id);
            return game is null ? Results.NotFound() : Results.Ok(game);
        })
        .WithName(GetEndpointGameName);

        //POST /games
        group.MapPost("/", (CreateGameDto newGame) =>
        {
            GameDto game = new(
                games.Count + 1,
                newGame.Name,
                newGame.Genre,
                newGame.Price,
                newGame.ReleaseDate
            );

            games.Add(game);

            return Results.CreatedAtRoute(GetEndpointGameName, new {id = game.Id}, game);
        });

        //PUT /games/id
        _ = group.MapPut("/{id}", (int id, UpdateGameDto updateGame) =>
        {
            var idx = games.FindIndex(game => game.Id == id);
            GameDto game = new(
                id,
                updateGame.Name,
                updateGame.Genre,
                updateGame.Price,
                updateGame.ReleaseDate
            );

            if (idx != -1)
            {
                games[idx] = game;
                return Results.NoContent();
            }
            else
            {
                games.Add(game);
                return Results.CreatedAtRoute(GetEndpointGameName, new { id = game.Id }, game);
            }
        });

        //DELETE /games/id
        group.MapDelete("/{id}", (int id) =>
        {
            games.RemoveAll(game => game.Id == id);

            return Results.NoContent();
        });
    }
}
