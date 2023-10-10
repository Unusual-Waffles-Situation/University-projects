#include <SPI.h>
#include <ESP8266WiFi.h>
#include <stdio.h>
#include <stdlib.h>

char ssid[] = ""; // Name of the network goes here
char pass[] = ""; // Password of the network
int keyIndex = 0;

//const int button = 8;            // GPIO 8 for the button       
int ledflag = 0;                   // LED status flag

WiFiServer server(80);

void setup() 
{
  // put your setup code here, to run once:

  //pinMode(button,INPUT);         // define button as an input 
  pinMode(LED_BUILTIN, OUTPUT);           // define LED as an output
  digitalWrite(LED_BUILTIN, LOW);         // turn output off just in case
  
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
          if (ledflag == 0)
          {
            ledflag = 1;
            
            digitalWrite(LED_BUILTIN, HIGH);
          }
        }

        if (currentLine.endsWith("GET /L"))
        {
          ledflag = 0;
          
          digitalWrite(LED_BUILTIN, LOW);
        }
      }
    }
  }
}
