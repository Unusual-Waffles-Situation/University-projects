import picture_management as pm
from tkinter import BOTTOM, Tk
from tkinter import Button

# Variables

testFrame = Tk()
testFrame.state("withdrawn")

testFrame.destroy()

def main_view():
    '''Creates the UI to take a picture'''

    mainFrame = Tk()    # Create the main frame window
    mainFrame.geometry('400x600')
    mainFrame.title("Take picture")

    takePictureButton = Button(mainFrame, text = "Take picture", command = lambda: take_picture()).pack(side = BOTTOM)

def take_picture():
    '''Saves the first frame of the video as an image file'''

    pm.take_picture()