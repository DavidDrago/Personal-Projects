using System;
using GameStore.API.Models;
using Microsoft.EntityFrameworkCore;

namespace GameStore.API.Data;

public static class DataExtensions
{
    public static void MigrateDb(this WebApplication app)
    {
        // for creating migration and creation in teminal
        // dotnet ef migrations add InitialCreate --output-dir Data\Migrations
        // dotnet ef database update
        // the above two commands can be used
        using var scope = app.Services.CreateScope();
        var dbContext = scope.ServiceProvider.GetRequiredService<GameStoreContext>();
        dbContext.Database.Migrate();
    }

    public static void AddGameStoreDB(this WebApplicationBuilder builder)
    {
        var connString = builder.Configuration.GetConnectionString("GameStoreDB"); // Connection string for the DBContext
        builder.Services.AddSqlite<GameStoreContext>( // dbContext has a scoped service lifetime similar to "builder.Services.AddScoped<GameStoreContext>();"
            connString, 
            optionsAction: options => options.UseSeeding((context, _) =>
            {
                if (!context.Set<Genre>().Any())
                {
                    context.Set<Genre>().AddRange(
                        new Genre { Name = "Fighting"},
                        new Genre { Name = "RPG"},
                        new Genre { Name = "Racing"},
                        new Genre { Name = "Adventure"},
                        new Genre { Name = "Open-World"},
                        new Genre { Name = "Platformer"},
                        new Genre { Name = "Sports"}
                    );

                    context.SaveChanges();
                }
            })
        );

        /*builder.Services.AddSqlite<GameStoreContext>( // dbContext has a scoped service lifetime similar to "builder.Services.AddScoped<GameStoreContext>();"
            connString, 
            optionsAction: options => options.UseSeeding((context, _) =>
            {
                if (!context.Set<Game>().Any())
                {
                    context.Set<Game>().AddRange(
                        new Game { GenreId=1, Name = "Street Fighter II", Price=19.99M, ReleaseDate = new DateOnly(1992, 7, 15)},
                        new Game { GenreId=4, Name = "Genshin Impact", Price=0, ReleaseDate = new DateOnly(2020, 9, 28)},
                        new Game { GenreId=2, Name = "Crimson Desert", Price=59.19M, ReleaseDate = new DateOnly(2026, 3, 19)}
                        new (1, "Street Fighter II", "Fighting", 19.99M, new DateOnly(1992, 7, 15)),
                        new (2, "Genshin Impact", "Action/Role-Playing", 0, new DateOnly(2020, 9, 28)),
                        new (3, "Crimson Desert", "Action/Adventure", 59.19M, new DateOnly(2026, 3, 19))
                    );

                    context.SaveChanges();
                }
            })
        );*/
    }
}
