using System.ComponentModel.DataAnnotations;
using System.Diagnostics.CodeAnalysis;

namespace GameStore.API.Dtos;

public record GameDto
(
    int Id,
    string Name,
    string Genre,
    decimal Price,
    DateOnly ReleaseDate
);

public record CreateGameDto
(
    [Required][StringLength(50)] string Name,
    [Range(1, 50)] int GenreId,
    [Range(0, 500)] decimal Price,
    DateOnly ReleaseDate
);

public record UpdateGameDto
(
    [Required][StringLength(50)] string Name,
    [Range(1, 50)] int GenreId,
    [Range(0, 500)] decimal Price,
    DateOnly ReleaseDate
);

public record GameDetailsDto
(
    int Id,
    string Name,
    int GenreId,
    decimal Price,
    DateOnly ReleaseDate
);

public record GenreDto(int Id, string Name);