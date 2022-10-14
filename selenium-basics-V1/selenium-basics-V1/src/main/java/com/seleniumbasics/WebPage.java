package com.seleniumbasics;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.apache.commons.codec.binary.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

@Component
public class WebPage {

    private static final Logger LOG = LoggerFactory.getLogger(WebPage.class);
    SelenideElement userName = Selenide.$(By.id("user-name"));
    SelenideElement passWord = Selenide.$(By.id("password"));
    SelenideElement loginBtn = Selenide.$(By.id("login"));
    SelenideElement okBtn = Selenide.$(By.className("raised-primary"));
    /*List<SelenideElement> currs = Selenide.$$("header-links d-inline-block font-16");
    for(SelenideElement curr :currs){
       if(StringUtils.equals(curr.getText(), "CONDUCTOR")){

       }
    }*/

    SelenideElement conductorBtn = Selenide.$(By.xpath("/html/body/slh-main/div/div[1]/slh-navbar/nav/div/div[1]/div[3]/div[2]"));
    SelenideElement nodeBtn = Selenide.$(By.xpath("/html/body/slh-main/div/div[2]/div[2]/ng-component/slh-horizontal-tab/ul/li[2]/a"));
    SelenideElement jobsBtn = Selenide.$(By.xpath("/html/body/slh-main/div/div[2]/div[2]/ng-component/slh-horizontal-tab/ul/li[5]/a"));
    SelenideElement configBtn = Selenide.$(By.xpath("/html/body/slh-main/div/div[2]/div[2]/ng-component/slh-horizontal-tab/ul/li[6]/a"));
    SelenideElement filterBtn = Selenide.$(By.id("practice"));
    SelenideElement addConfigBtn = Selenide.$(By.xpath("/html/body/slh-main/div/div[2]/div[2]/ng-component/slh-horizontal-tab/div/div/ng-component/div[1]/div/span[1]/span"));
    SelenideElement typeBtn = Selenide.$(By.id("fieldName"));
    SelenideElement valueBtn = Selenide.$(By.name("filedValue"));
    SelenideElement valuetypeBtn = Selenide.$(By.id("types"));
    SelenideElement stringBtn = Selenide.$(By.xpath("//*[@id=\"types\"]/option[1]"));
    SelenideElement saveBtn = Selenide.$(By.xpath("//*[@id=\"checkTbody\"]/tbody/tr[1]/td[5]/div/a[1]"));
    SelenideElement idBtn = Selenide.$(By.id("account-menu"));
    SelenideElement logOutBtn = Selenide.$(By.xpath("//*[@id=\"logout\"]/span"));

    RemoteWebDriver remoteWebDriver = null;

    public void init() throws Exception {

        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setPlatform(Platform.WINDOWS);
        ChromeOptions options = new ChromeOptions();
        options.merge(capabilities);

        URL url = new URL(String.format("http://%s:%d/wd/hub/", "localhost", 4444));
        LOG.debug("trying to set RemoteWebDriver, retryCount:");
        try {
            remoteWebDriver = new RemoteWebDriver(url, options);
            WebDriverRunner.setWebDriver(remoteWebDriver);
        } catch (Exception ex) {
            LOG.error("Error while setting up web driver", ex);
            throw ex;
        }
    }

    public void openSite() {
        Selenide.open("https://login-intg.smartlinkhealth.com/");
        Selenide.sleep(5000);

    }

    public void refresh() {
        Selenide.refresh();
    }
/*
    public void mobileCategory() {
//        Selenide.open("https://www.amazon.in/mobile-phones/b/?ie=UTF8&node=1389401031&ref_=nav_cs_mobiles_9292c6cb7b394d30b2467b8f631090a7");
        Selenide.$("body.a-aui_72554-c.a-aui_csa_templates_buildin_ww_exp_337518-t1.a-aui_csa_templates_buildin_ww_launch_337517-c.a-aui_csa_templates_declarative_ww_exp_337521-t1.a-aui_csa_templates_declarative_ww_launch_337520-c.a-aui_mm_desktop_exp_291916-t1.a-aui_mm_desktop_launch_291918-c.a-aui_mm_desktop_targeted_exp_291928-c.a-aui_mm_desktop_targeted_launch_291922-c.a-aui_pci_risk_banner_210084-c.a-aui_preload_261698-c.a-aui_rel_noreferrer_noopener_309527-c.a-aui_template_weblab_cache_333406-c.a-aui_tnr_v2_180836-c:nth-child(2) header.nav-opt-sprite.nav-flex.nav-locale-in.nav-lang-en.nav-ssl.nav-unrec.nav-progressive-attribute:nth-child(24) div.nav-sprite-v1.celwidget.nav-bluebeacon.nav-a11y-t1.bold-focus-hover.layout2.nav-flex.layout3.layout3-alt.nav-packard-glow.hamburger.nav-progressive-attribute.using-mouse div.nav-sprite:nth-child(5) div.nav-fill div:nth-child(1) div.nav-progressive-content > a.nav-a:nth-child(3)")
                .click();
    }*/

    // public void back() {
    //     Selenide.back();
    public void login() {
        userName.clear();
        userName.sendKeys("madan_mohan");
        passWord.clear();
        passWord.sendKeys("Welcome@123");
        loginBtn.click();
        Selenide.sleep(7000);
        okBtn.click();
        conductorBtn.click();
        Selenide.sleep(2000);
        nodeBtn.click();
        Selenide.sleep(10*1000);
        jobsBtn.click();
        Selenide.sleep(10*1000);
        configBtn.click();
        Selenide.sleep(5000);
        filterBtn.sendKeys("PAL");
        addConfigBtn.click();
        Selenide.sleep(2000);
        typeBtn.sendKeys("LIM");
        valueBtn.sendKeys("1");
        valuetypeBtn.click();
        stringBtn.click();
        Selenide.sleep(2000);
        saveBtn.click();
        Selenide.sleep(3000);
        idBtn.click();
        logOutBtn.click();
    }

}

//   public void forward() {
//       Selenide.forward();


   /* public void enterInSearchBox(){
        Selenide.sleep(1000);
        Selenide.$(By.name("field-keywords")).sendKeys("iPhone 12 mini");
    }

    public void search(){
        Selenide.sleep(1000);
        Selenide.$(By.id("nav-search-submit-button")).click();
    }

    public void clickOnFirst(){
        Selenide.sleep(1000);
        ElementsCollection ec = Selenide.$$(By.className("s-image"));
        ec.get(0).click();
    }*/

//    public void doSomething(){
//        Selenide
//    }

/*
public void shutdown(){
        Selenide.sleep(5000);
        WebDriverRunner.closeWebDriver();
        }

*/

