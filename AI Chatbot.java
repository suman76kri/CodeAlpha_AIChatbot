import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AIChatbot {
    private static Map<String, String> responses = new HashMap<>();

    public static void main(String[] args) {
        initializeKnowledgeBase();
        Scanner scanner = new Scanner(System.in);

        System.out.println("==================================================");
        System.out.println("        CODEALPHA AI CHATBOT SYSTEM               ");
        System.out.println("==================================================");
        System.out.println("Hello! I am your AI Virtual Assistant.");
        System.out.println("Type 'help' to see sample queries or 'exit' to quit.\n");

        while (true) {
            System.out.print("You: ");
            String userInput = scanner.nextLine().trim();

            if (userInput.isEmpty()) {
                continue;
            }

            if (userInput.equalsIgnoreCase("exit") || userInput.equalsIgnoreCase("quit") || userInput.equalsIgnoreCase("bye")) {
                System.out.println("Bot: Goodbye! Have a productive day ahead!");
                break;
            }

            String response = getBotResponse(userInput);
            System.out.println("Bot: " + response + "\n");
        }

        scanner.close();
    }

    private static void initializeKnowledgeBase() {
        responses.put("hello", "Hello there! How can I assist you today?");
        responses.put("hi", "Hi! Hope you're doing well. What can I do for you?");
        responses.put("hey", "Hey! Glad to chat with you. How can I help?");
        responses.put("how are you", "I'm functioning smoothly at full capacity! How about you?");
        responses.put("what is your name", "I am the CodeAlpha Virtual Assistant, built using Java.");
        responses.put("who created you", "I was developed as part of the CodeAlpha Java Programming Internship.");
        responses.put("what is java", "Java is a popular, class-based, object-oriented programming language designed for platform independence.");
        responses.put("what is oop", "OOP stands for Object-Oriented Programming, based on concepts like Inheritance, Encapsulation, Polymorphism, and Abstraction.");
        responses.put("help", "You can ask me about: greetings, current date/time, Java concepts, internship details, or type 'exit' to quit.");
    }

    private static String getBotResponse(String input) {
        String cleanInput = input.toLowerCase().replaceAll("[^a-zA-Z0-9 ]", "").trim();

        // Exact / Direct match
        if (responses.containsKey(cleanInput)) {
            return responses.get(cleanInput);
        }

        // Dynamic responses (Date & Time)
        if (cleanInput.contains("time") || cleanInput.contains("date")) {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("EEEE, dd MMMM yyyy, hh:mm a");
            return "Current system date and time is: " + dtf.format(LocalDateTime.now());
        }

        // Keyword based matching
        if (cleanInput.contains("name")) {
            return "I am the CodeAlpha Virtual Assistant bot!";
        }
        if (cleanInput.contains("creator") || cleanInput.contains("made you") || cleanInput.contains("developer")) {
            return "I was built by Suman as part of the CodeAlpha Java internship!";
        }
        if (cleanInput.contains("internship") || cleanInput.contains("codealpha")) {
            return "CodeAlpha offers practical software engineering internship tasks to build real-world skills!";
        }
        if (cleanInput.contains("thank")) {
            return "You're very welcome! Let me know if there's anything else you need.";
        }

        return "I'm sorry, I don't have an answer for that yet. Type 'help' to see what you can ask me!";
    }
}