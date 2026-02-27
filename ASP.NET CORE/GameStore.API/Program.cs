using GameStore.API.Data;
using GameStore.API.EndPoints;
using GameStore.API.Models;

var builder = WebApplication.CreateBuilder(args);
builder.Services.AddValidation(); // To add validation for required fields of Dtos which has annotations

builder.AddGameStoreDB(); //To create GameStoreDB with predefixed seeded values for Genre table

var app = builder.Build();

app.MapGamesEndPoints(); 
app.MapGenresEndPoints();

app.MigrateDb(); //To start migration of any new changes/creation of the database to sqlLite
 
app.Run();

