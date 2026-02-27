using System;
using System.Text.RegularExpressions;
using GameStore.API.Data;
using GameStore.API.Dtos;
using GameStore.API.Models;
using Microsoft.EntityFrameworkCore;

namespace GameStore.API.EndPoints;

public static class GenreEndPoints
{
    public static void MapGenresEndPoints(this WebApplication app)
    {
        var group = app.MapGroup("/genres");

        // GET /genres
        group.MapGet("/", async (GameStoreContext dbContext) =>
            await dbContext.Genres
                            .Select(genre => new GenreDto(genre.Id, genre.Name))
                            .AsNoTracking()
                            .ToListAsync()
            );
    }
}
