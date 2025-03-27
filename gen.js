import OpenAI from "openai";
import fs from "fs";

const ques = [
  {
    file: "1",
    text: "Create a servlet that performs a basic HTTP redirect to another page.",
  },
  {
    file: "2",
    text: "Write a servlet that accepts form data and stores it in a session attribute.",
  },
  {
    file: "3",
    text: "Develop a servlet that checks if a session is valid and displays a login page if it is not.",
  },
  {
    file: "4",
    text: "Create a servlet that sets and retrieves custom headers in an HTTP response.",
  },
  {
    file: "5",
    text: "Write a servlet that generates a simple HTML table from an array of data.",
  },
  {
    file: "6",
    text: "Create a servlet that prints the user-agent string from the request.",
  },
  {
    file: "7",
    text: "Write a servlet that stores a user's preferred language in a cookie.",
  },
  {
    file: "8",
    text: "Create a servlet that uses RequestDispatcher to forward a request to another servlet.",
  },
  {
    file: "9",
    text: "Develop a servlet that processes user input and performs basic validation.",
  },
  {
    file: "10",
    text: "Write a servlet that sets the session timeout to 5 minutes.",
  },
  {
    file: "11",
    text: "Create a servlet that reads and parses an XML file and displays its content to the user.",
  },
  {
    file: "12",
    text: "Develop a servlet that generates a PDF document dynamically using iText.",
  },
  {
    file: "13",
    text: "Write a servlet that performs user authentication and restricts access to authenticated users only.",
  },
  {
    file: "14",
    text: "Create a servlet that implements a RESTful API and uses JSON to communicate with the client.",
  },
  {
    file: "15",
    text: "Write a servlet that handles large file uploads efficiently.",
  },
  {
    file: "16",
    text: "Develop a servlet that integrates with a third-party authentication service (e.g., Google OAuth).",
  },
  {
    file: "17",
    text: "Create a servlet that implements WebSockets to create a real-time messaging system.",
  },
  {
    file: "18",
    text: "Write a servlet that accepts multiple file uploads and saves them to a server directory.",
  },
  {
    file: "19",
    text: "Create a servlet that stores user preferences in a database and loads them on the next visit.",
  },
  {
    file: "20",
    text: "Write a servlet that handles a multi-step user registration process and stores information in a session.",
  },
  {
    file: "21",
    text: "Create a servlet that implements a session-based shopping cart with add/remove functionality.",
  },
  {
    file: "22",
    text: "Develop a servlet that authenticates users with JWT (JSON Web Tokens) for stateless authentication.",
  },
  {
    file: "23",
    text: "Write a servlet that handles asynchronous processing and displays a progress bar while processing large tasks.",
  },
  {
    file: "24",
    text: "Create a servlet that performs an SQL injection vulnerability test by accepting user input and attempting to execute unsafe SQL queries.",
  },
  {
    file: "25",
    text: "Develop a servlet that connects to an external API, handles JSON responses, and displays the data in a user-friendly format.",
  },
  {
    file: "26",
    text: "Write a servlet that implements multi-threaded processing for handling high-concurrency scenarios.",
  },
  {
    file: "27",
    text: "Create a servlet that interacts with a message broker (e.g., JMS) and processes incoming messages asynchronously.",
  },
  {
    file: "28",
    text: "Write a servlet that sends personalized emails based on user data entered in a form.",
  },
  {
    file: "29",
    text: "Develop a servlet that provides secure communication using HTTPS and validates SSL certificates.",
  },
  {
    file: "30",
    text: "Create a servlet-based application that handles complex data filtering from a database, processes it, and displays it in a paginated format.",
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
