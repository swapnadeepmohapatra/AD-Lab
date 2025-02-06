import puppeteer from "puppeteer";
import path from "path";
import fs from "fs";
import { Document, Packer, Media } from "docx";

async function takeScreenshotAndSaveToWord(htmlFilePath, outputScreenshotPath) {
  // Launch Puppeteer
  const browser = await puppeteer.launch();
  const page = await browser.newPage();

  // Convert the HTML file path to a file URL
  const fileUrl = `file://${path.resolve(htmlFilePath)}`;

  try {
    // Open the HTML file
    await page.goto(fileUrl, { waitUntil: "networkidle0" });

    // Take a screenshot and save it as a PNG
    await page.screenshot({ path: outputScreenshotPath, fullPage: true });
    console.log(`Screenshot saved as ${outputScreenshotPath}`);

    // // Verify if the screenshot exists
    // if (!fs.existsSync(outputScreenshotPath)) {
    //   throw new Error("Screenshot file not found!");
    // }

    // // Read the image file as a buffer
    // const imageBuffer = fs.readFileSync(outputScreenshotPath);

    // // Ensure the buffer is valid
    // if (!imageBuffer) {
    //   throw new Error("Failed to load screenshot buffer!");
    // }

    // // Create a Word document with metadata
    // const doc = new Document({
    //   creator: "Your Name",
    //   title: "HTML Screenshot",
    //   description: "Screenshot of an HTML file inserted into a Word document",
    // });

    // // Add the screenshot image to the Word document
    // const image = Media.addImage(doc, imageBuffer);
    // doc.addSection({
    //   children: [new Paragraph(image)],
    // });

    // // Write the Word document to a file
    // const packedDoc = await Packer.toBuffer(doc);
    // fs.writeFileSync(wordFilePath, packedDoc);
    // console.log(`Word file saved as ${wordFilePath}`);
  } catch (error) {
    console.error("Error:", error);
  } finally {
    // Close the browser
    await browser.close();
  }
}

// Usage example
// const htmlFilePath = "./Lab 06/01.html"; // Path to your HTML file
// const outputScreenshotPath = "screenshot.png"; // Path to save the screenshot
// const wordFilePath = "./output.docx"; // Path to save the Word file
// takeScreenshotAndSaveToWord(htmlFilePath, outputScreenshotPath, wordFilePath);

for (let i = 10; i < 31; i++) {
  // Usage example
  const htmlFilePath = `./Lab 06/${i}.html`; // Path to your HTML file
  const outputScreenshotPath = "screenshot" + i + ".png"; // Path to save the screenshot
  takeScreenshotAndSaveToWord(htmlFilePath, outputScreenshotPath);
}
