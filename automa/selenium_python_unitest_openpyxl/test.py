import unittest
from selenium import webdriver
from openpyxl import load_workbook
from selenium.webdriver.common.keys import Keys

class PythonGoogleSearch(unittest.TestCase):
 
     
    def setUp(self):
        self.driver = webdriver.Chrome()
          
        
        

    def test_search_in_python_org(self):
        driver = self.driver
        wb = load_workbook('c:/python_data.xlsx')
        # Loading the excel workbook
        sheet = wb.get_sheet_by_name('Sheet1')
        # Loading the excel sheet by name 
        driver.get( sheet['A2'].value)
        # Loading the URL from Excel
        self.assertIn("Google", driver.title)
        elemntSearchInput = driver.find_element_by_id("lst-ib")
        elemntSearchInput.send_keys( sheet['B2'].value)
        # Loading the Search Word from Excel
        elemntSearchButton = driver.find_element_by_name("btnK")
        elemntSearchButton.click()
        selenium_link = driver.find_element_by_link_text(sheet['C2'].value)
        selenium_link.click();
        self.assertIn(sheet['C2'].value, driver.title)

    def tearDown(self):
        self.driver.close()

if __name__ == "__main__":
    unittest.main()