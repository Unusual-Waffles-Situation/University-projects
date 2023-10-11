from tkinter import Tk
from tkinter import Button
from tkinter import Label
import load_image as li
import take_picture_view as tpv

# Variables

mainFrame = Tk()    # Create the main frame window
mainFrame.geometry('1280x720')
mainFrame.title("Udogram")

def main_window():
    '''Creates the main window'''

    imgLabel = Label(mainFrame)
    imgLabel.place(x = 100, y = 50)

    loadImageButton = Button(mainFrame, text = "Press to load an image", command = lambda: open_image(imgLabel))
    loadImageButton.place(x = 75, y = 0)

    takePictureButton = Button(mainFrame, text = "Press here to take a picture", command = lambda: take_picture())
    takePictureButton.place(x = 1000, y = 250)

def open_image(label):
    '''Reference the "load_image.py" function to get an image'''

    li.open_image(mainFrame, label)

def take_picture():
    '''Reference the "take_picture_view.py" file to take a picture'''

    tpv.main_view()

main_window()    # Calls the function to show the main frame

mainFrame.mainloop()    # Loops the main fram until the program is closed