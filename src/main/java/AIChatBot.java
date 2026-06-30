import java.util.Scanner;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class AIChatBot {
    //Reads the gemini API Key from the system environment
    private static final String API_KEY = System.getenv("GEMINI_API_KEY");

    public static void main(String[] args) {

        //Initialize required objects
        Scanner sc = new Scanner(System.in);
        HttpClient client = HttpClient.newHttpClient();
        ObjectMapper mapper = new ObjectMapper();

        // Check if the API key is available 
        if (API_KEY == null || API_KEY.isBlank()) {
            System.out.println("Error: GEMINI_API_KEY environment variable is not set.");
            sc.close();
            return;
        }
        System.out.println("=== Gold Fish AI ChatBot ===");

        // chatbot loop
        while (true) {

            // Read user input 
            System.out.print("You: ");
            String prompt = sc.nextLine();

             // Exit the chatbot
            if (prompt.equalsIgnoreCase("bye")) {
                System.out.println("Gold Fish: Bye!");
                break;
            }

           // Create JSON request body for gemini API 
            String requestBody = """
                    {
                        "contents": [
                        {
                            "parts": [
                                {
                                    "text": "%s"
                                }
                            ]
                        }
                        ]
                    }
                    """.formatted(prompt);

            //Gemini API endpoint 
            String url = "https://generativelanguage.googleapis.com/v1beta/models/gemini-2.5-flash:generateContent?key="
                    + API_KEY;

            //Build the HTTP POST request
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                    .build();

            try {

               // Send request an drecieve response
                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

                //Parse JSON response using jackson 
                JsonNode root = mapper.readTree(response.body());

                //Extract AI- generated reply 
                String aiReply = root
                        .path("candidates")
                        .get(0)
                        .path("content")
                        .path("parts")
                        .get(0)
                        .path("text")
                        .asText();

                //Display AI response
                System.out.println("Gold Fish: " + aiReply);

            } catch (Exception e) {

                //handle API or network errors
                System.out.println("Gold Fish: Sorry! Something went wrong.");
                System.out.println(e.getMessage());
            }

        }

        sc.close();
    }
}