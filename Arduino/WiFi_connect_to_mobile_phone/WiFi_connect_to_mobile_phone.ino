#include <SPI.h>
#include <ESP8266WiFi.h>

char ssid[] = ""; // Name of the network goes here
char pass[] = ""; // Password goes here
int keyIndex = 0;

WiFiServer server(80);

void setup() 
{
  // put your setup code here, to run once:

  pinMode(LED_BUILTIN, OUTPUT);
  digitalWrite(LED_BUILTIN, LOW);
  
  Serial.begin(115200);
  Serial.print("Connecting WiFi: ");
  Serial.println(ssid);

  WiFi.mode(WIFI_STA);
  WiFi.begin(ssid, pass);
  while (WiFi.status() != WL_CONNECTED) 
  {
    Serial.print(".");
    delay(500);
  }

  server.begin();

}

void loop() 
{
  // put your main code here, to run repeatedly:

  WiFiClient client = server.available();

  if (client)
  {
    String currentLine = "";

    while (client.connected())
    {
      if (client.available())
      {
        char c = client.read();

        if (c == '\n')
        {
          if (currentLine.length() == 0)
          {
            client.println("HTTP/1.1 200 OK");
            client.println("Content-type:text/html");
            client.println();
            client.print("Value at A0 is");
            client.print(analogRead(A0));
            client.print("<br>");

            client.println();

            break;
          }

          else
          {
            currentLine = "";
          }
        }

        else if (c != '\r')
        {
          currentLine += c;
        }

        if (currentLine.endsWith("GET /H"))
        {
          digitalWrite(LED_BUILTIN, HIGH);
        }

        if (currentLine.endsWith("GET /L"))
        {
          digitalWrite(LED_BUILTIN, LOW);
        }
      }
    }
  }
}
