using Microsoft.Playwright;
using Microsoft.Playwright.NUnit;
using System.Threading.Tasks;
using NUnit.Framework;
using System;
using System.Collections.Generic;
using System.Text;

namespace Playwright_dotNet;

public class PlaywrightTest : PageTest
{
    [SetUp]
    public async Task Setup()
    {
        // In order to run tests in Headed mode we need to configure it in command line for this style of tests.
        // $env:HEADED="1"
        // dotnet test
        // follow this for more info: https://playwright.dev/dotnet/docs/running-tests
        //
        await Page.GotoAsync("https://demoqa.com/");
    }

    [Test]
    public async Task Test1()
    {
        await Page.ClickAsync("text=Elements");

        //Take the screenshot of the page
        await Page.ScreenshotAsync(new PageScreenshotOptions { Path = "demoqa_Elements.png" });

        await Page.ClickAsync("text=Text Box");

        // # is used for id, . is used for class
        await Page.FillAsync("#userName", "John Doe");
        await Page.FillAsync("#userEmail", "JohnDoe@mail.com");
        await Page.FillAsync("#currentAddress", "123 Main St, Anytown, USA");
        await Page.FillAsync("#permanentAddress", "456 Elm St, Othertown, USA");
        await Page.ClickAsync("#submit");

        // verify the output
        // we can use Expect API to verify the output instead of using Assert.That() method. Expect API is a more powerful and flexible way to verify the output. It provides a lot of methods to verify the output, such as ToBeVisibleAsync(), ToHaveTextAsync(), ToHaveAttributeAsync(), etc.
        await Expect(Page.Locator("#email")).ToBeVisibleAsync();
        // var isexist = await Page.Locator("#email").IsVisibleAsync();
        // By default, NUnit's Assert.That() method uses the Is.True constraint to check if the condition is true. To use false constraint, you can use the Is.False constraint.
        // Assert.That(isexist);

        // Take the screenshot of the page
        await Page.ScreenshotAsync(new PageScreenshotOptions { Path = "demoqa_TextBox.png" });
    }

    [Test]
    public async Task WaitTest() {
        await Page.ClickAsync("text=Elements");
        await Page.ClickAsync("text=Web Tables");
        await Page.ClickAsync("#addNewRecordButton");
        await Page.ScreenshotAsync(new PageScreenshotOptions { Path = "demoqa_WebTables_AddRecord.png" });
        await Page.ClickAsync(".btn-close");
        await Page.ScreenshotAsync(new PageScreenshotOptions { Path = "demoqa_WebTables.png" });
    }

    [Test]
    public async Task LoginTest() { 
        await Page.ClickAsync("text=Book Store Application");
        var bookStoreApplicationPage = new Pages.BookStoreApplicationPage(Page);
        await bookStoreApplicationPage.GotoLogin();
        await bookStoreApplicationPage.Login("JohnDoe", "JohnDoe123@");
        await bookStoreApplicationPage.GotoBookStore();
        await bookStoreApplicationPage.ClickBook("Git Pocket Guide");
        var isExist = await bookStoreApplicationPage.IsBookExist("Git Pocket Guide");
        Assert.That(isExist);
        await bookStoreApplicationPage.Logout();
    }

    [Test]
    public async Task LoginTestWithRequestAndResponse()
    {
        await Page.ClickAsync("text=Book Store Application");
        var bookStoreApplicationPage = new Pages.BookStoreApplicationPage(Page);
        await bookStoreApplicationPage.GotoLogin();
        await bookStoreApplicationPage.Login("JohnDoe", "JohnDoe123@");

        // var waitResponse = Page.WaitForResponseAsync("**/Books");
        // await bookStoreApplicationPage.GotoBookStore();
        // var getResponse = await waitResponse;
        // the above can also be written in a single line as below, which is more concise and easier to read.
        var response = await Page.RunAndWaitForResponseAsync(async () =>
        {
            await bookStoreApplicationPage.GotoBookStore();
        }, x => x.Url.Contains("/BookStore/v1/Books") && x.Status == 200 && x.StatusText == "OK");

        await bookStoreApplicationPage.ClickBook("Git Pocket Guide");
        await bookStoreApplicationPage.Logout();
    }
}

