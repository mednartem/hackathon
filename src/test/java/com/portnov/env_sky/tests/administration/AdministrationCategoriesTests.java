package com.portnov.env_sky.tests.administration;

import com.portnov.env_sky.logic.dictionary.ui.administration.AdministrationAlertNotification;
import com.portnov.env_sky.logic.dictionary.ui.administration.AdministrationEndpointUi;
import com.portnov.env_sky.logic.dictionary.ui.administration.AdministrationHeaderButton;
import com.portnov.env_sky.logic.dictionary.ui.administration.AdministrationMenu;
import com.portnov.env_sky.logic.helpers.RandomData;
import com.portnov.env_sky.logic.jupiter.WebTest;
import com.portnov.env_sky.logic.pages.administration.*;
import com.portnov.env_sky.logic.steps.BaseSteps;
import io.qameta.allure.Link;
import org.junit.jupiter.api.Test;

@WebTest
public class AdministrationCategoriesTests {

    private final BaseSteps baseSteps = new BaseSteps();
    private final AdministrationCategoriesPage administrationCategoriesPage = new AdministrationCategoriesPage();
    private final AdministrationCategoryCreatePage administrationCategoryCreatePage = new AdministrationCategoryCreatePage();
    private final AdministrationMenuWidget administrationMenuWidget = new AdministrationMenuWidget();
    private final AdministrationHeaderWidget administrationHeaderWidget = new AdministrationHeaderWidget();
    private final AdministrationAlertNotificationWidget administrationAlertNotificationWidget = new AdministrationAlertNotificationWidget();

    @Test
    void openCategoriesPage() {
        baseSteps
                .iOpenBasePageWithAdminCookie(AdministrationEndpointUi.DASHBOARD);
        administrationMenuWidget
                .iClickMenu(AdministrationMenu.CATALOG)
                .iClickMenu(AdministrationMenu.CATEGORIES);
        administrationCategoriesPage
                .pageShouldBeOpened();
    }

    @Test
    @Link(value = "Test case TEAM1-9", url = "https://jira.portnov.com/browse/TEAM1-9")
    void addNewCategoryBasic() {
        String name = RandomData.generateNameCategory();
        String description = RandomData.generateDescriptionCategory();

        baseSteps
                .iOpenBasePageWithAdminCookie(AdministrationEndpointUi.CATALOG_CATEGORIES);
        administrationHeaderWidget
                .iClickBtn(AdministrationHeaderButton.ADD_NEW);
        administrationCategoryCreatePage
                .iTypeName(name)
                .iTypeDescription(description);
        administrationHeaderWidget
                .iClickBtn(AdministrationHeaderButton.SAVE);
        administrationAlertNotificationWidget
                .alertNotificationShouldBeVisible(AdministrationAlertNotification.THE_NEW_CATEGORY_HAS_BEEN_ADDED_SUCCESSFULLY);
        administrationCategoriesPage
                .pageShouldBeOpened()
                .categoryShouldBeDisplayInTheTable(name);
    }

    @Test
    @Link(value = "Test case TEAM1-10", url = "https://jira.portnov.com/browse/TEAM1-10")
    void addNewSubCategoryBasic() {
        String nameParentCategory = RandomData.generateNameCategory();
        String nameSubCategory = RandomData.generateNameCategory();
        String description = RandomData.generateDescriptionCategory();


        //todo change create category via api/bd
        //create category
        baseSteps
                .iOpenBasePageWithAdminCookie(AdministrationEndpointUi.CATALOG_CATEGORIES_CREATE);
        administrationCategoryCreatePage
                .iTypeName(nameParentCategory)
                .iTypeDescription(description);
        administrationHeaderWidget
                .iClickBtn(AdministrationHeaderButton.SAVE);
        administrationAlertNotificationWidget
                .alertNotificationShouldBeVisible(AdministrationAlertNotification.THE_NEW_CATEGORY_HAS_BEEN_ADDED_SUCCESSFULLY);
        administrationCategoriesPage
                .pageShouldBeOpened()
                .categoryShouldBeDisplayInTheTable(nameParentCategory);

        //createSubCategory
        administrationHeaderWidget
                .iClickBtn(AdministrationHeaderButton.ADD_NEW);
        administrationCategoryCreatePage
                .iTypeName(nameSubCategory)
                .iTypeDescription(description)
                .iSelectParentCategory(nameParentCategory);
        administrationHeaderWidget
                .iClickBtn(AdministrationHeaderButton.SAVE);
        administrationAlertNotificationWidget
                .alertNotificationShouldBeVisible(AdministrationAlertNotification.THE_NEW_CATEGORY_HAS_BEEN_ADDED_SUCCESSFULLY);
        administrationCategoriesPage
                .pageShouldBeOpened()
                .categoryShouldBeDisplayInTheTable(nameParentCategory + " >> " + nameSubCategory);
    }

    @Test
    @Link(value = "Test case TEAM1-15", url = "https://jira.portnov.com/browse/TEAM1-15")
    void addNewCategoryAdvanced() {
        String name = RandomData.generateNameCategory();
        String description = RandomData.generateDescriptionCategory();

        baseSteps
                .iOpenBasePageWithAdminCookie(AdministrationEndpointUi.CATALOG_CATEGORIES_CREATE);
        administrationCategoryCreatePage
                .pageShouldBeOpened()
                .iTypeName(name)
                .iTypeDescription(description)
                .iSwitchBasicToAdvanced()
                .iUploadPicture();
        administrationHeaderWidget
                .iClickBtn(AdministrationHeaderButton.SAVE);
        administrationAlertNotificationWidget
                .alertNotificationShouldBeVisible(AdministrationAlertNotification.THE_NEW_CATEGORY_HAS_BEEN_ADDED_SUCCESSFULLY);
        administrationCategoriesPage
                .pageShouldBeOpened()
                .categoryShouldBeDisplayInTheTable(name);
    }

    @Test
    @Link(value = "Test case TEAM1-18", url = "https://jira.portnov.com/browse/TEAM1-18")
    void addNewSubCategoryAdvanced() {
        String nameParentCategory = RandomData.generateNameCategory();
        String nameSubCategory = RandomData.generateNameCategory();
        String description = RandomData.generateDescriptionCategory();


        //todo change create category via api/bd
        //create category
        baseSteps
                .iOpenBasePageWithAdminCookie(AdministrationEndpointUi.CATALOG_CATEGORIES_CREATE);
        administrationCategoryCreatePage
                .pageShouldBeOpened()
                .iTypeName(nameParentCategory)
                .iTypeDescription(description)
                .iSwitchBasicToAdvanced()
                .iUploadPicture();
        administrationHeaderWidget
                .iClickBtn(AdministrationHeaderButton.SAVE);
        administrationAlertNotificationWidget
                .alertNotificationShouldBeVisible(AdministrationAlertNotification.THE_NEW_CATEGORY_HAS_BEEN_ADDED_SUCCESSFULLY);
        administrationCategoriesPage
                .pageShouldBeOpened()
                .categoryShouldBeDisplayInTheTable(nameParentCategory);

        administrationHeaderWidget
                .iClickBtn(AdministrationHeaderButton.ADD_NEW);
        administrationCategoryCreatePage
                .pageShouldBeOpened()
                .iTypeName(nameSubCategory)
                .iTypeDescription(description)
                .iSelectParentCategory(nameParentCategory)
                .iSwitchBasicToAdvanced()
                .iUploadPicture();
        administrationHeaderWidget
                .iClickBtn(AdministrationHeaderButton.SAVE);
        administrationAlertNotificationWidget
                .alertNotificationShouldBeVisible(AdministrationAlertNotification.THE_NEW_CATEGORY_HAS_BEEN_ADDED_SUCCESSFULLY);
        administrationCategoriesPage
                .pageShouldBeOpened()
                .categoryShouldBeDisplayInTheTable(nameParentCategory + " >> " + nameSubCategory);
    }

    @Test
    @Link(value = "Test case TEAM1-19", url = "https://jira.portnov.com/browse/TEAM1-19")
    void addNewCategoryBasicByClickSaveAndContinue() {
        String name = RandomData.generateNameCategory();
        String description = RandomData.generateDescriptionCategory();

        baseSteps
                .iOpenBasePageWithAdminCookie(AdministrationEndpointUi.CATALOG_CATEGORIES_CREATE);
        administrationCategoryCreatePage
                .iTypeName(name)
                .iTypeDescription(description);
        administrationHeaderWidget
                .iClickBtn(AdministrationHeaderButton.SAVE_AND_CONTINUE_EDIT);
        administrationAlertNotificationWidget
                .alertNotificationShouldBeVisible(AdministrationAlertNotification.THE_NEW_CATEGORY_HAS_BEEN_ADDED_SUCCESSFULLY);
        administrationCategoryCreatePage
                .pageShouldBeOpened()
                .nameFieldShouldHaveValue(name)
                .descriptionFieldShouldHaveText(description);
        administrationHeaderWidget
                .buttonShouldBeVisible(AdministrationHeaderButton.PREVIEW)
                .buttonShouldBeVisible(AdministrationHeaderButton.DELETE);
    }

    @Test
    @Link(value = "Test case TEAM1-20", url = "https://jira.portnov.com/browse/TEAM1-20")
    void addNewCategoryAdvancedByClickSaveAndContinue() {
        String name = RandomData.generateNameCategory();
        String description = RandomData.generateDescriptionCategory();

        baseSteps
                .iOpenBasePageWithAdminCookie(AdministrationEndpointUi.CATALOG_CATEGORIES_CREATE);
        administrationCategoryCreatePage
                .pageShouldBeOpened()
                .iTypeName(name)
                .iTypeDescription(description)
                .iSwitchBasicToAdvanced()
                .iUploadPicture();
        administrationHeaderWidget
                .iClickBtn(AdministrationHeaderButton.SAVE_AND_CONTINUE_EDIT);
        administrationAlertNotificationWidget
                .alertNotificationShouldBeVisible(AdministrationAlertNotification.THE_NEW_CATEGORY_HAS_BEEN_ADDED_SUCCESSFULLY);
        administrationCategoryCreatePage
                .pageShouldBeOpened()
                .nameFieldShouldHaveValue(name)
                .descriptionFieldShouldHaveText(description);
        administrationHeaderWidget
                .buttonShouldBeVisible(AdministrationHeaderButton.PREVIEW)
                .buttonShouldBeVisible(AdministrationHeaderButton.DELETE);
    }
}
