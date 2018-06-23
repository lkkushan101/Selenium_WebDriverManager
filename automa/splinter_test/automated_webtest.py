from splinter import Browser

with Browser('firefox') as browser:
    # Visit URL
    url = "http://www.google.lk"
    browser.visit(url)

    # fill the query form with our search term
    
    browser.fill('q', 'Python')

    # find the search button on the page and click it
    button = browser.find_by_name('btnK')
    button.click()
    
    link = browser.find_by_text('Welcome to Python.org')

    link.click()
    