package com.portnov.env_sky.tests.administration.catalog;

import com.portnov.env_sky.logic.data.FillCategoryEntity;
import com.portnov.env_sky.logic.data.RandomData;
import com.portnov.env_sky.logic.db.dao.CategoryDAO;
import com.portnov.env_sky.logic.db.model.CategoryEntity;
import com.portnov.env_sky.logic.dictionary.ui.administration.*;
import com.portnov.env_sky.logic.jupiter.Dao;
import com.portnov.env_sky.logic.jupiter.DaoExtension;
import com.portnov.env_sky.logic.jupiter.WebTest;
import com.portnov.env_sky.logic.pages.administration.categories.AdministrationCategoriesPage;
import com.portnov.env_sky.logic.pages.administration.categories.AdministrationCategoryCreatePage;
import com.portnov.env_sky.logic.pages.administration.widgets.*;
import com.portnov.env_sky.logic.pages.BasePage;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Link;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@Epic("Administration")
@Feature("Catalog")
@Story("Categories")
@WebTest
@ExtendWith(DaoExtension.class)
public class AdministrationCategoriesTests {

    private final BasePage basePage = new BasePage();
    private final AdministrationCategoriesPage categoriesPage = new AdministrationCategoriesPage();
    private final AdministrationCategoryCreatePage categoryCreatePage = new AdministrationCategoryCreatePage();
    private final AdministrationMenuWidget menuWidget = new AdministrationMenuWidget();
    private final AdministrationHeaderWidget headerWidget = new AdministrationHeaderWidget();
    private final AdministrationAlertNotificationWidget alertNotificationWidget = new AdministrationAlertNotificationWidget();
    private final AdministrationModalWidget modalWidget = new AdministrationModalWidget();
    private final AdministrationDataTableLengthWidget dataTableLengthWidget = new AdministrationDataTableLengthWidget();
    @Dao
    private CategoryDAO categoryDAO;

    @Test
    void openCategoriesPage() {
        basePage
                .iOpenBasePageWithAdminCookie(AdministrationEndpointUi.DASHBOARD);
        menuWidget
                .iClickMenu(AdministrationMenu.CATALOG)
                .iClickMenu(AdministrationMenu.CATEGORIES);
        categoriesPage
                .pageShouldBeOpened();
    }

    @Test
    @Link(value = "Test case TEAM1-9", url = "https://jira.portnov.com/browse/TEAM1-9")
    void addNewCategoryBasic() {
        String name = RandomData.generateNameCategory();
        String description = RandomData.generateDescriptionCategory();

        basePage
                .iOpenBasePageWithAdminCookie(AdministrationEndpointUi.CATALOG_CATEGORIES);
        headerWidget
                .iClickBtn(AdministrationHeaderButton.ADD_NEW);
        categoryCreatePage
                .iTypeName(name)
                .iTypeDescription(description);
        headerWidget
                .iClickBtn(AdministrationHeaderButton.SAVE);
        alertNotificationWidget
                .alertNotificationShouldBeVisible(AdministrationAlertNotification.THE_NEW_CATEGORY_HAS_BEEN_ADDED_SUCCESSFULLY);
        categoriesPage
                .pageShouldBeOpened();
        dataTableLengthWidget
                .iSelectLength(AdministrationDataTableLength.HUNDRED);
        categoriesPage
                .categoryShouldBeDisplayInTheTable(name);
    }

    @Test
    @Link(value = "Test case TEAM1-10", url = "https://jira.portnov.com/browse/TEAM1-10")
    void addNewSubCategoryBasic() {
        String nameParentCategory = RandomData.generateNameCategory();
        String nameSubCategory = RandomData.generateNameCategory();
        String description = RandomData.generateDescriptionCategory();


        //todo need to determine why the category won't appear in the paren category dropdown
        //create category
        basePage
                .iOpenBasePageWithAdminCookie(AdministrationEndpointUi.CATALOG_CATEGORIES_CREATE);
        categoryCreatePage
                .iTypeName(nameParentCategory)
                .iTypeDescription(description);
        headerWidget
                .iClickBtn(AdministrationHeaderButton.SAVE);
        alertNotificationWidget
                .alertNotificationShouldBeVisible(AdministrationAlertNotification.THE_NEW_CATEGORY_HAS_BEEN_ADDED_SUCCESSFULLY);
        categoriesPage
                .pageShouldBeOpened();
        dataTableLengthWidget
                .iSelectLength(AdministrationDataTableLength.HUNDRED);
        categoriesPage
                .categoryShouldBeDisplayInTheTable(nameParentCategory);

        //createSubCategory
        headerWidget
                .iClickBtn(AdministrationHeaderButton.ADD_NEW);
        categoryCreatePage
                .iTypeName(nameSubCategory)
                .iTypeDescription(description)
                .iSelectParentCategory(nameParentCategory);
        headerWidget
                .iClickBtn(AdministrationHeaderButton.SAVE);
        alertNotificationWidget
                .alertNotificationShouldBeVisible(AdministrationAlertNotification.THE_NEW_CATEGORY_HAS_BEEN_ADDED_SUCCESSFULLY);
        categoriesPage
                .pageShouldBeOpened();
        dataTableLengthWidget
                .iSelectLength(AdministrationDataTableLength.HUNDRED);
        categoriesPage
                .categoryShouldBeDisplayInTheTable(nameParentCategory + " >> " + nameSubCategory);
    }

    @Test
    @Link(value = "Test case TEAM1-15", url = "https://jira.portnov.com/browse/TEAM1-15")
    void addNewCategoryAdvanced() {
        String name = RandomData.generateNameCategory();
        String description = RandomData.generateDescriptionCategory();

        basePage
                .iOpenBasePageWithAdminCookie(AdministrationEndpointUi.CATALOG_CATEGORIES_CREATE);
        categoryCreatePage
                .pageShouldBeOpened()
                .iTypeName(name)
                .iTypeDescription(description)
                .iSwitchBasicToAdvanced()
                .iUploadPicture();
        headerWidget
                .iClickBtn(AdministrationHeaderButton.SAVE);
        alertNotificationWidget
                .alertNotificationShouldBeVisible(AdministrationAlertNotification.THE_NEW_CATEGORY_HAS_BEEN_ADDED_SUCCESSFULLY);
        categoriesPage
                .pageShouldBeOpened();
        dataTableLengthWidget
                .iSelectLength(AdministrationDataTableLength.HUNDRED);
        categoriesPage
                .categoryShouldBeDisplayInTheTable(name);
    }

    @Test
    @Link(value = "Test case TEAM1-18", url = "https://jira.portnov.com/browse/TEAM1-18")
    void addNewSubCategoryAdvanced() {
        String nameParentCategory = RandomData.generateNameCategory();
        String nameSubCategory = RandomData.generateNameCategory();
        String description = RandomData.generateDescriptionCategory();


        //todo need to determine why the category won't appear in the paren category dropdown
        //create category
        basePage
                .iOpenBasePageWithAdminCookie(AdministrationEndpointUi.CATALOG_CATEGORIES_CREATE);
        categoryCreatePage
                .pageShouldBeOpened()
                .iTypeName(nameParentCategory)
                .iTypeDescription(description)
                .iSwitchBasicToAdvanced()
                .iUploadPicture();
        headerWidget
                .iClickBtn(AdministrationHeaderButton.SAVE);
        alertNotificationWidget
                .alertNotificationShouldBeVisible(AdministrationAlertNotification.THE_NEW_CATEGORY_HAS_BEEN_ADDED_SUCCESSFULLY);
        categoriesPage
                .pageShouldBeOpened();
        dataTableLengthWidget
                .iSelectLength(AdministrationDataTableLength.HUNDRED);
        categoriesPage
                .categoryShouldBeDisplayInTheTable(nameParentCategory);

        headerWidget
                .iClickBtn(AdministrationHeaderButton.ADD_NEW);
        categoryCreatePage
                .pageShouldBeOpened()
                .iTypeName(nameSubCategory)
                .iTypeDescription(description)
                .iSelectParentCategory(nameParentCategory)
                .iSwitchBasicToAdvanced()
                .iUploadPicture();
        headerWidget
                .iClickBtn(AdministrationHeaderButton.SAVE);
        alertNotificationWidget
                .alertNotificationShouldBeVisible(AdministrationAlertNotification.THE_NEW_CATEGORY_HAS_BEEN_ADDED_SUCCESSFULLY);
        categoriesPage
                .pageShouldBeOpened();
        dataTableLengthWidget
                .iSelectLength(AdministrationDataTableLength.HUNDRED);
        categoriesPage
                .categoryShouldBeDisplayInTheTable(nameParentCategory + " >> " + nameSubCategory);
    }

    @Test
    @Link(value = "Test case TEAM1-19", url = "https://jira.portnov.com/browse/TEAM1-19")
    void addNewCategoryBasicByClickSaveAndContinue() {
        String name = RandomData.generateNameCategory();
        String description = RandomData.generateDescriptionCategory();

        basePage
                .iOpenBasePageWithAdminCookie(AdministrationEndpointUi.CATALOG_CATEGORIES_CREATE);
        categoryCreatePage
                .iTypeName(name)
                .iTypeDescription(description);
        headerWidget
                .iClickBtn(AdministrationHeaderButton.SAVE_AND_CONTINUE_EDIT);
        alertNotificationWidget
                .alertNotificationShouldBeVisible(AdministrationAlertNotification.THE_NEW_CATEGORY_HAS_BEEN_ADDED_SUCCESSFULLY);
        categoryCreatePage
                .pageShouldBeOpened()
                .nameFieldShouldHaveValue(name)
                .descriptionFieldShouldHaveText(description);
        headerWidget
                .buttonShouldBeVisible(AdministrationHeaderButton.PREVIEW)
                .buttonShouldBeVisible(AdministrationHeaderButton.DELETE);
    }

    @Test
    @Link(value = "Test case TEAM1-20", url = "https://jira.portnov.com/browse/TEAM1-20")
    void addNewCategoryAdvancedByClickSaveAndContinue() {
        String name = RandomData.generateNameCategory();
        String description = RandomData.generateDescriptionCategory();

        basePage
                .iOpenBasePageWithAdminCookie(AdministrationEndpointUi.CATALOG_CATEGORIES_CREATE);
        categoryCreatePage
                .pageShouldBeOpened()
                .iTypeName(name)
                .iTypeDescription(description)
                .iSwitchBasicToAdvanced()
                .iUploadPicture();
        headerWidget
                .iClickBtn(AdministrationHeaderButton.SAVE_AND_CONTINUE_EDIT);
        alertNotificationWidget
                .alertNotificationShouldBeVisible(AdministrationAlertNotification.THE_NEW_CATEGORY_HAS_BEEN_ADDED_SUCCESSFULLY);
        categoryCreatePage
                .pageShouldBeOpened()
                .nameFieldShouldHaveValue(name)
                .descriptionFieldShouldHaveText(description);
        headerWidget
                .buttonShouldBeVisible(AdministrationHeaderButton.PREVIEW)
                .buttonShouldBeVisible(AdministrationHeaderButton.DELETE);
    }

    @Test
    @Link(value = "Test case TEAM1-41", url = "https://jira.portnov.com/browse/TEAM1-41")
    void deleteCategoryFromEditForm() {
        CategoryEntity categoryEntity = new FillCategoryEntity().fillRequiredFields();
        categoryDAO.create(categoryEntity);

        basePage
                .iOpenBasePageWithAdminCookie(AdministrationEndpointUi.CATALOG_CATEGORIES);
        categoriesPage
                .clickEditBtnAtTheCategory(categoryEntity.getName());
        categoryCreatePage
                .pageShouldBeOpened();
        headerWidget
                .iClickBtn(AdministrationHeaderButton.DELETE);
        modalWidget
                .iClickBtn(AdministrationModalButton.DELETE);
        alertNotificationWidget
                .alertNotificationShouldBeVisible(AdministrationAlertNotification.THE_CATEGORY_HAS_BEEN_DELETED_SUCCESSFULLY);
        categoriesPage
                .pageShouldBeOpened();
        dataTableLengthWidget
                .iSelectLength(AdministrationDataTableLength.HUNDRED);
        categoriesPage
                .categoryShouldNotBeDisplayInTheTable(categoryEntity.getName());
    }

    @Test
    @Link(value = "Test case TEAM1-42", url = "https://jira.portnov.com/browse/TEAM1-42")
    void deleteCategoryFromCategoriesPage() {
        CategoryEntity categoryEntity = new FillCategoryEntity().fillRequiredFields();
        categoryDAO.create(categoryEntity);

        basePage
                .iOpenBasePageWithAdminCookie(AdministrationEndpointUi.CATALOG_CATEGORIES);
        categoriesPage
                .selectCheckboxAtTheCategory(categoryEntity.getName());
        headerWidget
                .iClickBtn(AdministrationHeaderButton.DELETE_SELECTED);
        modalWidget
                .iClickBtn(AdministrationModalButton.YES);
        categoriesPage
                .pageShouldBeOpened();
        dataTableLengthWidget
                .iSelectLength(AdministrationDataTableLength.HUNDRED);
        categoriesPage
                .categoryShouldNotBeDisplayInTheTable(categoryEntity.getName());
    }
}
