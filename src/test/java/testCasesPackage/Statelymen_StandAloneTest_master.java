package testCasesPackage;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import utils.ExtentReportListener;  // <--- correct import
import testpages.Checkout_Process;
import testpages.Email_To_PlanSelection;
import testpages.Homepage_Landing;
import testpages.Quiz_Till_Email;
import base.baseMaster;

@Listeners(ExtentReportListener.class)
public class Statelymen_StandAloneTest_master extends baseMaster {

    private Homepage_Landing home;
    private Quiz_Till_Email quiz;
    private Email_To_PlanSelection email;
    private Checkout_Process checkout;

    @Test(priority = 1)
    public void openHomepage() {
        home = new Homepage_Landing(driver);
        home.openApplication();
        home.clickStartQuiz();
    }

    @Test(priority = 2, dependsOnMethods = "openHomepage")
    public void completeQuiz() throws Exception {
        quiz = new Quiz_Till_Email(driver);
        quiz.completeQuizTillEmail();
    }
/*
    @Test(priority = 3, dependsOnMethods = "completeQuiz")
    public void enterEmail() {
        email = new Email_To_PlanSelection(driver);
        email.enterEmailTillPlan();
    }

    @Test(priority = 4, dependsOnMethods = "enterEmail")
    public void selectPlan() {
        // Example if plan selection is automated
        System.out.println("Plan selected successfully");
    }

    @Test(priority = 5, dependsOnMethods = "selectPlan")
    public void completeCheckout() throws Exception {
        checkout = new Checkout_Process(driver);
        checkout.completeCheckout();
    }
  */   
}
