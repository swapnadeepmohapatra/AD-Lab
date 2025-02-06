import OpenAI from "openai";
import fs from "fs";

const ques = [
  {
    file: "01",
    text: "Build a program to create a dynamic registration form. Validate the input and save the data in local storage.",
  },
  {
    file: "02",
    text: "Write a program to display the top news headlines using an external API (e.g., News API).",
  },
  {
    file: "03",
    text: "Create a dynamic user profile page where users can upload a profile picture, edit their details, and save changes.",
  },
  {
    file: "04",
    text: "Develop a program to create a dynamic calendar that allows users to add and view events for each date.",
  },
  {
    file: "05",
    text: "Write a script to implement a password strength checker that provides feedback based on the entered password.",
  },
  {
    file: "06",
    text: "Create a dynamic polling system where users can vote for options and view the updated poll results in real time.",
  },
  {
    file: "07",
    text: "Build a program to create a photo slideshow with automatic and manual navigation options.",
  },
  {
    file: "08",
    text: "Write a program to create a responsive navigation bar with dropdowns and a hamburger menu for smaller screens.",
  },
  {
    file: "09",
    text: "Develop a program to build a portfolio website template. Include sections for dynamically adding projects and experiences.",
  },
  {
    file: "10",
    text: "Write a program to implement a basic blogging platform. Allow users to add, edit, and delete posts.",
  },
  ,
  {
    file: "11",
    text: "Design a task management application with features like priority setting, task sorting, and progress tracking.",
  },
  {
    file: "12",
    text: "Create a dynamic quiz system with timed questions. Display the results and time taken at the end.",
  },
  {
    file: "13",
    text: "Build a program to simulate a real-time chat interface. Simulate message sending and receiving.",
  },
  {
    file: "14",
    text: "Write a program to implement a recommendation system for books/movies based on user preferences.",
  },
  {
    file: "15",
    text: "Develop a program to create a virtual keyboard that dynamically inputs text into a field.",
  },
  {
    file: "16",
    text: "Create a program to implement a responsive image editor with zoom, crop, and filter options.",
  },
  {
    file: "17",
    text: "Build a program to simulate a stock ticker that displays live data fetched from an external API.",
  },
  {
    file: "18",
    text: "Write a program to implement a dynamic e-commerce interface with product filtering and a cart system.",
  },
  {
    file: "19",
    text: "Create a program to design a real-time collaboration tool where multiple users can edit a shared text document.",
  },
  {
    file: "20",
    text: "Develop a simple game (e.g., Tic-Tac-Toe or Snake) using JavaScript and HTML.",
  },
  {
    file: "21",
    text: "Develop a weather application that fetches and displays current weather data for a city entered by the user. ",
  },
  {
    file: "22",
    text: "Build a program to implement a dynamic contact form with a dropdown for query types and real-time validation. ",
  },
  {
    file: "23",
    text: "Write a script to create a responsive Kanban board where users can drag and drop tasks between columns. ",
  },
  {
    file: "24",
    text: "Create a program to simulate a currency converter using live exchange rates from an API. ",
  },
  {
    file: "25",
    text: "Design a program to create a live chat application using WebSocket for real-time communication. ",
  },
  {
    file: "26",
    text: "Implement a virtual bookshelf where users can add books, rate them, and categorize them. ",
  },
  {
    file: "27",
    text: "Build a program that integrates Google Maps API to display a map with a user-defined location marker. ",
  },
  {
    file: "28",
    text: "Create a program to implement a responsive chart (e.g., pie or bar chart) using a charting library like Chart.js. ",
  },
  {
    file: "29",
    text: "Develop a program for a social media feed simulator, displaying user posts with options to like and comment dynamically. ",
  },
  {
    file: "30",
    text: "Write a program to build a simple 2D animation (e.g., a ball bouncing within the screen) using HTML canvas and JavaScript.",
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
