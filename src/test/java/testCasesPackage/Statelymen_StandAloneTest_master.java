package testCasesPackage;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import base.BaseClass;
import testpages.Checkout_Process;
import testpages.Email_To_PlanSelection;
import testpages.Homepage_Landing;
import testpages.Quiz_Till_Email;
import utils.ExtentReportListener;

@Listeners(ExtentReportListener.class)
public class Statelymen_StandAloneTest_master extends BaseClass {

    Homepage_Landing home;
    Quiz_Till_Email quiz;
    Email_To_PlanSelection email;
    Checkout_Process checkout;

    // -----------------------------
    // Step 1 – Open Homepage
    // -----------------------------
    @Test(priority = 1)
    public void openHomepage() {
        home = new Homepage_Landing(driver);
        home.openApplication();
        home.clickStartQuiz();
    }

    // -----------------------------
    // Step 2 – Quiz till email
    // -----------------------------
    @Test(priority = 2, dependsOnMethods = "openHomepage")
    public void completeQuiz() throws Exception {
        quiz = new Quiz_Till_Email(driver);
        quiz.completeQuizTillEmail();
    }

    // -----------------------------
    // Step 3 – Enter Email
    // -----------------------------
    @Test(priority = 3, dependsOnMethods = "completeQuiz")
    public void enterEmail() {
        email = new Email_To_PlanSelection(driver);
        email.enterEmailTillPlan();
    }

    // -----------------------------
    // Step 4 – Select Plan
    // -----------------------------
    @Test(priority = 4, dependsOnMethods = "enterEmail")
    public void selectPlan() {
        System.out.println("Plan selected successfully");
    }

    // -----------------------------
    // Step 5 – Checkout
    // -----------------------------
    @Test(priority = 5, dependsOnMethods = "selectPlan")
    public void completeCheckout() throws Exception {
        checkout = new Checkout_Process(driver);
        checkout.completeCheckout();
    }
}
