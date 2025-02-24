import OpenAI from "openai";
import fs from "fs";

const ques = [
  {
    file: "11",
    text: "Create a servlet-based application that displays the current session ID and tracks the number of visits by a user.",
  },
  {
    file: "12",
    text: "Write a servlet that accepts POST data (e.g., username and password) and checks the credentials against hardcoded values.",
  },
  {
    file: "13",
    text: "Implement a servlet that reads an uploaded file (e.g., text file) and displays its content to the user.",
  },
  {
    file: "14",
    text: "Write a servlet that forwards a request to another servlet and passes parameters along with it.",
  },
  {
    file: "15",
    text: "Develop a servlet that uses HttpSession to store and retrieve user data, such as username and preferences.",
  },
  {
    file: "16",
    text: "Create a servlet that logs request details (IP address, User-Agent) to a file or database.",
  },
  {
    file: "17",
    text: "Implement a servlet that sets an expiration time for cookies and tracks when the cookie expires.",
  },
  {
    file: "18",
    text: "Write a servlet that handles both GET and POST requests and processes the form accordingly.",
  },
  {
    file: "19",
    text: "Build a servlet-based login system that stores the user credentials in memory for validation.",
  },
  {
    file: "20",
    text: "Create a servlet that dynamically generates an HTML table from hardcoded data.",
  },
  {
    file: "21",
    text: "Write a servlet that implements a simple user authentication system using session management.",
  },
  {
    file: "22",
    text: "Create a servlet-based shopping cart that allows users to add, remove, and view items in the cart.",
  },
  {
    file: "23",
    text: "Develop a servlet that processes multiple file uploads at once using multipart/form-data.",
  },
  {
    file: "24",
    text: "Write a servlet that integrates with a relational database (e.g., MySQL) to perform CRUD (Create, Read, Update, Delete) operations.",
  },
  {
    file: "25",
    text: "Create a servlet that handles and returns an error message (e.g., 404 or 500) to the client in a user-friendly format.",
  },
  {
    file: "26",
    text: "Implement a servlet-based system that uses query parameters to filter data from a database and displays the filtered data in a table.",
  },
  {
    file: "27",
    text: "Write a servlet that processes user input (JSON) and returns a JSON response.",
  },
  {
    file: "28",
    text: "Develop a servlet that integrates with a third-party REST API (e.g., weather API) and displays the response data.",
  },
  {
    file: "29",
    text: "Create a servlet that implements a simple chat application using WebSocket and servlets.",
  },
  {
    file: "30",
    text: "Build a servlet that sends an email to a user using JavaMail API when a form is submitted",
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
          "You are a code generating assistant, generate java servlet page, use import jakarta.servlet. HelloServlet should be the class name. and the package name should be com.swapnadeep.week1.ad_lab_servlet . Also use @WebServlet()",
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
