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
    [Required][StringLength(20)] string Genre,
    [Range(0, 500)] decimal Price,
    DateOnly ReleaseDate
);

public record UpdateGameDto
(
    [Required][StringLength(50)] string Name,
    [Required][StringLength(20)] string Genre,
    [Range(0, 500)] decimal Price,
    DateOnly ReleaseDate
);