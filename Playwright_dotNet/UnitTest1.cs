using System.Threading.Tasks;
using Microsoft.Playwright;
using NUnit.Framework;

namespace Playwright_dotNet;

public class Tests
{
    [SetUp]
    public void Setup()
    {
    }

    [Test]
    public async Task Test1()
    {
        // Create playwright instanse
        using var playwright = await Playwright.CreateAsync();
        //Browser - By default all the tests run in headless mode
        await using var browser = await playwright.Chromium.LaunchAsync(new BrowserTypeLaunchOptions { Headless = false });

        //Page
        var page = await browser.NewPageAsync();
        await page.GotoAsync("https://demoqa.com/");
        await page.ClickAsync("text=Elements");

        //Take the screenshot of the page
        await page.ScreenshotAsync(new PageScreenshotOptions { Path = "demoqa_Elements.png" });

        await page.ClickAsync("text=Text Box");

        // # is used for id, . is used for class
        await page.FillAsync("#userName", "John Doe");
        await page.FillAsync("#userEmail", "JohnDoe@mail.com");
        await page.FillAsync("#currentAddress", "123 Main St, Anytown, USA");
        await page.FillAsync("#permanentAddress", "456 Elm St, Othertown, USA");
        await page.ClickAsync("#submit");

        // verify the output
        var isexist = await page.Locator("#email").IsVisibleAsync();

        // Take the screenshot of the page
        await page.ScreenshotAsync(new PageScreenshotOptions { Path = "demoqa_TextBox.png" });

        // By default, NUnit's Assert.That() method uses the Is.True constraint to check if the condition is true. To use false constraint, you can use the Is.False constraint.
        Assert.That(isexist);
    }
}
