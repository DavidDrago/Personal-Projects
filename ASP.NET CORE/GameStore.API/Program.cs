using GameStore.API.Dtos;
using GameStore.API.EndPoints;

var builder = WebApplication.CreateBuilder(args);
builder.Services.AddValidation(); // To add validation for required fields of Dtos which has annotations

var app = builder.Build();

app.MapGamesEndPoints();
 
app.Run();

