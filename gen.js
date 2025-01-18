import OpenAI from "openai";
import fs from "fs";

const ques = [
  ,
  {
    file: "01:",
    text: "Create a program to add a new paragraph to the page whenever a button is clicked.",
  },
  {
    file: "02:",
    text: "Write a script to dynamically change the content of an HTML table based on user input.",
  },
  {
    file: "03:",
    text: "Develop a program where hovering over a button changes its color and text dynamically.",
  },
  {
    file: "04:",
    text: "Write a program to display a live clock on a web page using JavaScript.",
  },
  {
    file: "05:",
    text: "Design a webpage where users can click on items in a list to mark them as completed. Use line-through styling for completed items.",
  },
  {
    file: "06:",
    text: "Create a form that validates email and phone numbers in real time and displays error messages dynamically.",
  },
  {
    file: "07:",
    text: "Develop a program to create a modal dialog box that opens and closes dynamically.",
  },
  {
    file: "08:",
    text: "Write a script to create a dynamic dropdown menu. Selecting a category displays related subcategories in another dropdown.",
  },
  {
    file: "09:",
    text: "Build a program to implement a collapsible FAQ section with expandable and collapsible answers.",
  },
  {
    file: "10:",
    text: "Create a program where clicking on a button animates an element (e.g., move a square across the screen).",
  },
];

const openai = new OpenAI({
  apiKey: "",
});

ques.forEach(async (q) => {
  const completion = await openai.chat.completions.create({
    model: "gpt-3.5-turbo",
    messages: [
      {
        role: "developer",
        content:
          "You are a code generating assistant, generate html page, use js to write the script in the html file itself, don't use any css for the following question.",
      },
      {
        role: "user",
        content: q.text,
      },
    ],
  });

  fs.writeFileSync(
    q.file + ".html",
    completion.choices[0].message.content
      .replace("```html\n", "")
      .replace("```  ", "")
      .replace("```", "")
  );
});
