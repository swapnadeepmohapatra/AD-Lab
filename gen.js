import OpenAI from "openai";
import fs from "fs";

const ques = [
  {
    file: "16",
    text: "Develop a program to dynamically generate a table based on user input for rows and columns.",
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
