import OpenAI from "openai";
import fs from "fs";

const ques = [
  {
    file: "1",
    text: "Create a servlet that displays 'Welcome to the Java Servlet Lab' in a browser.",
  },
  {
    file: "2",
    text: "Write a servlet that displays a 'Hello, [name]' message after taking input via an HTML form.",
  },
  {
    file: "3",
    text: "Develop a servlet that accepts and displays a user’s favorite color.",
  },
  {
    file: "4",
    text: "Write a servlet that reads a user’s session and displays the current session ID.",
  },
  {
    file: "5",
    text: "Create a servlet that redirects to a different page based on user input.",
  },
  {
    file: "6",
    text: "Write a servlet that validates form fields (like name and email) before submitting.",
  },
  {
    file: "7",
    text: "Develop a servlet that generates a dynamic greeting based on the current time of day.",
  },
  {
    file: "8",
    text: "Create a servlet that accepts and prints the user-agent of the client.",
  },
  {
    file: "9",
    text: "Write a servlet that displays all cookies sent by the browser.",
  },
  {
    file: "10",
    text: "Create a servlet that provides a link to download a text file.",
  },
  {
    file: "11",
    text: "Write a servlet that interacts with a MySQL database to fetch records and display them on the page.",
  },
  {
    file: "12",
    text: "Develop a servlet that handles file uploads using multipart/form-data and saves the files on the server.",
  },
  {
    file: "13",
    text: "Create a servlet that implements a simple chat application using WebSockets.",
  },
  {
    file: "14",
    text: "Write a servlet that implements a RESTful API to perform CRUD operations on a resource.",
  },
  {
    file: "15",
    text: "Develop a servlet that handles multi-step user registration and stores intermediate data in a session.",
  },
  {
    file: "16",
    text: "Create a servlet that integrates with a payment gateway (e.g., PayPal) for processing payments.",
  },
  {
    file: "17",
    text: "Write a servlet that handles form data and sends an email confirmation to the user.",
  },
  {
    file: "18",
    text: "Develop a servlet that validates user login using a database for authentication.",
  },
  {
    file: "19",
    text: "Write a servlet that uses JWT for handling stateless authentication.",
  },
  {
    file: "20",
    text: "Create a servlet that generates a PDF receipt for a user's order and sends it via email.",
  },
  {
    file: "21",
    text: "Write a servlet that creates a dynamic report from a database and generates a downloadable CSV file.",
  },
  {
    file: "22",
    text: "Develop a servlet that provides asynchronous processing for long-running tasks (e.g., processing large datasets).",
  },
  {
    file: "23",
    text: "Write a servlet that manages a multi-tier application architecture with servlets, JSP, and JDBC.",
  },
  {
    file: "24",
    text: "Create a servlet that implements secure file handling with restrictions based on file type and size.",
  },
  {
    file: "25",
    text: "Develop a servlet that integrates with external APIs (e.g., weather or news) and displays real-time data.",
  },
  {
    file: "26",
    text: "Write a servlet that implements a complex search filter system to query a database based on user input.",
  },
  {
    file: "27",
    text: "Create a servlet that allows users to upload images and displays thumbnails after uploading.",
  },
  {
    file: "28",
    text: "Develop a servlet that provides user authentication using OAuth 2.0.",
  },
  {
    file: "29",
    text: "Write a servlet that allows users to interact with a message queue (e.g., JMS).",
  },
  {
    file: "30",
    text: "Create a servlet that integrates with a cloud-based storage service (e.g., AWS S3) for file storage.",
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
          "You are a code generating assistant, generate java servlet page, use import jakarta.servlet. HelloServlet should be the class name. and the package name should be com.swapnadeep.week1.ad_lab_servlet . Also use @WebServlet(). Give the full code, implementing all the requirements.",
      },
      {
        role: "user",
        content: q.text,
      },
    ],
  });

  fs.writeFileSync(
    q.file + ".java",
    completion.choices[0].message.content
      .replace("```java\n", "")
      .replace("```  ", "")
      .replace("```", "")
  );
});
