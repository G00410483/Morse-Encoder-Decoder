# Morse-Encoder-Decoder
GUI Java Application Project that can encode and decode files using Morse code.


Morse Encoder/Decoder
Morse code is communication system that uses dashes and dots to represent letters and numbers. 
The communication system was developed in early 19th century and is still used today in various 
context. 

The Morse Encoder and Decoder GUI Java Application is a graphical user interface tool that can 
encode and decode files using Morse code. The application is built using Java programming 
languages and uses Map class to store the Morse code mappings.
Encode/Decode

To encode/decode, select the file you want to encode/decode in the file browser and click the 
Encode/Decode button. The encoded/decoded file will be displayed (translated) in the output field 
once the file is loaded.

Implementation

The “MorseWindow” class provides graphical user interface for the user to interact with the 
application. It creates window with the output field, and buttons: Browse (to browser for specific 
file), Encode (to encode the selected file), Decode (to decode the selected file), Clear (to clear the 
output), and Quit (to exit the application). 
“Encode” class contains the logic for encoding the message into Morse code, and the “Decode” class 
contains the logic for decoding the Morse message into plain text. Both classes use ‘Map’ object to 
store Morse code mappings, take string message as input and return output equivalent to the input. 
In Encode class each character in the input message is converted to its corresponding Morse code 
sequence, with spaces between each sequence. If a character in a message is not a letter or a 
number, character is ignored. In Decode class input message is split into ‘words’ (group of 
sequences), each word is split into ‘letters’ (sequences) and each sequence is converted to plain text
