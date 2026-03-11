using System;
using System.Collections.Generic;
using System.Text;
using Microsoft.Playwright;

namespace Playwright_dotNet.Pages;

public class BookStoreApplicationPage
{
    private IPage page;

    // we can make this better by creating them as preperties rather than assigning them in the constructor,
    // this way we can reuse them across the methods and avoid locating them multiple times which will improve the performance of our tests
    /*private readonly ILocator lnkLogin;
    private readonly ILocator txtUserName;
    private readonly ILocator txtPassword;
    private readonly ILocator btnLogin;
    private readonly ILocator lnkBookStore;
    private readonly ILocator btnLogout;*/
    private ILocator lnkLogin => page.GetByRole(AriaRole.Link, new() { Name = "Login" });
    private ILocator txtUserName => page.Locator("#userName");
    private ILocator txtPassword => page.Locator("#password");
    private ILocator btnLogin => page.Locator("#login");
    private ILocator lnkBookStore => page.Locator("text=Go To Book Store");
    private ILocator btnLogout => page.Locator("text=Log out");

    public BookStoreApplicationPage(IPage page)
    {
        this.page = page;
        // lnkLogin = page.GetByRole(AriaRole.Link, new() { Name = "Login" });
        // lnkLogin = page.Locator("text=Login");
        // txtUserName = page.Locator("#userName");
        // txtPassword = page.Locator("#password");
        // btnLogin = page.Locator("#login");
        // lnkBookStore = page.Locator("text=Go To Book Store");
        // btnLogout = page.Locator("text=Log out");
    }

    public async Task GotoLogin()
    {
        await page.RunAndWaitForNavigationAsync( async () =>
         {
             await lnkLogin.ClickAsync();
         }, new PageRunAndWaitForNavigationOptions
         {
             UrlString = "**/login"
         });
    }

    public async Task Login(string username, string password)
    {
        await txtUserName.FillAsync(username);
        await txtPassword.FillAsync(password);
        await btnLogin.ClickAsync();
    }

    public async Task GotoBookStore() => await lnkBookStore.ClickAsync();

    // Using Aria Attributes
    public async Task ClickBook(string bookName) => await page.GetByRole(AriaRole.Link, new() { Name = $"{bookName}" }).ClickAsync();

    public async Task<bool> IsBookExist(string bookName) => await page.GetByText(bookName).IsVisibleAsync();

    public async Task Logout() => await btnLogout.ClickAsync();
}
