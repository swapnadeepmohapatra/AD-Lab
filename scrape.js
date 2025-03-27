import jsdom from "jsdom";
import fs from "fs";

// Function to scrape data from screener.in
async function scrapeScreener(stockUrl) {
  try {
    // Fetch the HTML content from the URL
    const response = await fetch(stockUrl);
    if (!response.ok) {
      throw new Error(
        `Failed to fetch: ${response.status} ${response.statusText}`
      );
    }

    const html = await response.text();

    // Create a DOM parser to process the HTML
    // const parser = new DOMParser();
    const dom = new jsdom.JSDOM(html);
    const doc = dom.window.document;

    // Extract basic company information
    const companyName = doc.querySelector("h1")?.textContent.trim();
    const companyHeader = doc
      .querySelector(".company-header")
      ?.textContent.trim();

    // Extract current market price and related data
    const marketPrice = doc.querySelector(".current-price")?.textContent.trim();
    const priceChange = doc
      .querySelector(".change-percent")
      ?.textContent.trim();

    // Extract ratios and metrics
    const ratios = {};
    const ratioElements = doc.querySelectorAll(".valuation-ratios .flex-row");
    ratioElements.forEach((row) => {
      const label = row
        .querySelector(".flex-column:first-child")
        ?.textContent.trim();
      const value = row
        .querySelector(".flex-column:last-child")
        ?.textContent.trim();
      if (label && value) {
        ratios[label] = value;
      }
    });

    // Extract quarterly results
    const quarterlyResults = [];
    const quarterlyTable = doc.querySelector("table.quarterly-results");
    if (quarterlyTable) {
      const headers = Array.from(
        quarterlyTable.querySelectorAll("thead th")
      ).map((th) => th.textContent.trim());
      const rows = quarterlyTable.querySelectorAll("tbody tr");

      rows.forEach((row) => {
        const rowData = {};
        Array.from(row.querySelectorAll("td")).forEach((cell, index) => {
          rowData[headers[index] || `column${index}`] = cell.textContent.trim();
        });
        quarterlyResults.push(rowData);
      });
    }

    // Extract profit & loss data
    const profitLoss = [];
    const plTable = doc.querySelector("table.profit-loss");
    if (plTable) {
      const headers = Array.from(plTable.querySelectorAll("thead th")).map(
        (th) => th.textContent.trim()
      );
      const rows = plTable.querySelectorAll("tbody tr");

      rows.forEach((row) => {
        const rowData = {};
        Array.from(row.querySelectorAll("td")).forEach((cell, index) => {
          rowData[headers[index] || `column${index}`] = cell.textContent.trim();
        });
        profitLoss.push(rowData);
      });
    }

    // Extract balance sheet data
    const balanceSheet = [];
    const bsTable = doc.querySelector("table.balance-sheet");
    if (bsTable) {
      const headers = Array.from(bsTable.querySelectorAll("thead th")).map(
        (th) => th.textContent.trim()
      );
      const rows = bsTable.querySelectorAll("tbody tr");

      rows.forEach((row) => {
        const rowData = {};
        Array.from(row.querySelectorAll("td")).forEach((cell, index) => {
          rowData[headers[index] || `column${index}`] = cell.textContent.trim();
        });
        balanceSheet.push(rowData);
      });
    }

    // Extract cash flow data
    const cashFlow = [];
    const cfTable = doc.querySelector("table.cash-flow");
    if (cfTable) {
      const headers = Array.from(cfTable.querySelectorAll("thead th")).map(
        (th) => th.textContent.trim()
      );
      const rows = cfTable.querySelectorAll("tbody tr");

      rows.forEach((row) => {
        const rowData = {};
        Array.from(row.querySelectorAll("td")).forEach((cell, index) => {
          rowData[headers[index] || `column${index}`] = cell.textContent.trim();
        });
        cashFlow.push(rowData);
      });
    }

    // Extract shareholding pattern
    const shareholding = [];
    const shTable = doc.querySelector("table.shareholding");
    if (shTable) {
      const headers = Array.from(shTable.querySelectorAll("thead th")).map(
        (th) => th.textContent.trim()
      );
      const rows = shTable.querySelectorAll("tbody tr");

      rows.forEach((row) => {
        const rowData = {};
        Array.from(row.querySelectorAll("td")).forEach((cell, index) => {
          rowData[headers[index] || `column${index}`] = cell.textContent.trim();
        });
        shareholding.push(rowData);
      });
    }

    // Compile all data into a single JSON object
    const scrapedData = {
      companyInfo: {
        name: companyName,
        header: companyHeader,
        currentPrice: marketPrice,
        priceChange: priceChange,
      },
      valuationRatios: ratios,
      quarterlyResults: quarterlyResults,
      profitLoss: profitLoss,
      balanceSheet: balanceSheet,
      cashFlow: cashFlow,
      shareholding: shareholding,
      scrapedAt: new Date().toISOString(),
      sourceUrl: stockUrl,
    };

    return scrapedData;
  } catch (error) {
    console.error("Error scraping data:", error);
    return { error: error.message };
  }
}

// Usage example:
// This function needs to be run in a browser environment or using a headless browser like Puppeteer
// since it relies on DOMParser and fetch which are browser APIs

/*
  Example usage:
  scrapeScreener('https://www.screener.in/company/RELIANCE/')
    .then(data => {
      console.log(JSON.stringify(data, null, 2));
      // You can also download the data as a JSON file
      // downloadJson(data, 'reliance-data.json');
    })
    .catch(err => console.error('Scraping failed:', err));
  */

// Helper function to download JSON data as a file
function downloadJson(data, filename) {
  const blob = new Blob([JSON.stringify(data, null, 2)], {
    type: "application/json",
  });
  const url = URL.createObjectURL(blob);
  const a = document.createElement("a");
  a.href = url;
  a.download = filename;
  document.body.appendChild(a);
  a.click();
  document.body.removeChild(a);
  URL.revokeObjectURL(url);
}

scrapeScreener("https://www.screener.in/company/RELIANCE/")
  .then((data) => {
    console.log(JSON.stringify(data, null, 2));
    // You can also download the data as a JSON file
    // downloadJson(data, 'reliance-data.json');
  })
  .catch((err) => console.error("Scraping failed", err));
