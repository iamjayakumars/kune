/*
 *
 * Copyright (C) 2007-2011 The kune development team (see CREDITS for details)
 * This file is part of kune.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 */
package cc.kune.selenium.tools;

import java.util.Arrays;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;

import cc.kune.selenium.login.LoginPageObject;

import com.google.inject.Singleton;

public class SeleniumModule extends PageObjectModule {

  public SeleniumModule() {
  }

  @Override
  protected void configure() {

    // bind(WebDriver.class).toInstance(creatFirefoxDriver());
    final WebDriver driver = createChromeDriver();
    bind(WebDriver.class).toInstance(driver);
    bind(GenericWebDriver.class).in(Singleton.class);

    // "http://127.0.0.1:8888/ws/?locale=en&log_level=INFO&gwt.codesvr=127.0.0.1:9997#");

    bind(ElementLocatorFactory.class).toInstance(
        new AjaxElementLocatorFactory(driver, SeleniumConstants.TIMEOUT));

    final EventFiringWebDriver eventFiring = new EventFiringWebDriver(driver);
    bind(EventFiringWebDriver.class).toInstance(eventFiring);

    // Page Objects here!
    bind(LoginPageObject.class).in(Singleton.class);
  }

  private WebDriver createChromeDriver() {
    // http://code.google.com/p/selenium/wiki/ChromeDriver
    System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
    final DesiredCapabilities capabilities = DesiredCapabilities.chrome();
    // http://peter.sh/experiments/chromium-command-line-switches/
    capabilities.setCapability("chrome.switches", Arrays.asList("--disable-translate"));
    capabilities.setCapability("chrome.binary", "/usr/bin/chromium-browser");
    final WebDriver driver = new ChromeDriver(capabilities);
    return driver;
  }

  @SuppressWarnings("unused")
  private FirefoxDriver creatFirefoxDriver() {
    // final FirefoxProfile profile = new FirefoxProfile();
    // profile.setPreference("webdriver.firefox.profile",
    // SeleniumConstants.FIREFOX_PROFILE_NAME);
    // profile.setPreference("webdriver.firefox.useExisting",true);

    final ProfilesIni allProfiles = new ProfilesIni();
    final FirefoxProfile profile = allProfiles.getProfile(SeleniumConstants.FIREFOX_PROFILE_NAME);
    // profile.setPreferences("foo.bar", 23);
    final FirefoxDriver driver = new FirefoxDriver(profile);
    return driver;
  }
}
