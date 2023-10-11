from tkinter import BOTTOM, Button, filedialog
from PIL import ImageTk, Image
import eye_and_face_recognition as efr

def open_image(frame, label):
    '''Function to open the file explorer of the OS (Windows by default), and to pick an image'''

    filename = filedialog.askopenfilename(initialdir = "/Pictures",
                                          title = "Select a File",
                                          filetypes = (("Image files",
                                                        "*.jpg* *.png*"),
                                                       ))

    img = Image.open(filename)    # Opens the image file
    imgVariable = ImageTk.PhotoImage(img)

    height = imgVariable.height()    # Gets the image height 
    
    width = imgVariable.width()    # Gets the image width 

    imageHeight = height
    imageWidth = width

    if height > 1000 or width > 1000:
        if height > width:
            imageHeight = int(height / 2)    # and divides it in 2

            imageWidth = width

        else:
            imageWidth = int(width / 2)    # and divides it in 2

            imageHeight = height

    else:
        if width > height:    # If the width is bigger than the height, reverse the values. This adjust the image to make it less distorted
            imageHeight = width
        
            imageWidth = height

        else:
            imageHeight = height
        
            imageWidth = width

    resized_image = img.resize((imageHeight, imageWidth), Image.ANTIALIAS)    # Resize the image to better fit the label

    new_image = ImageTk.PhotoImage(resized_image)    # Parses it to a variable that can be used in the label

    label.configure(image = new_image)
    label.pack()
    label.image = new_image

    testFaceRecButton = Button(frame, text = "Test facial recognition", command = lambda: get_custom_image(label, filename)).pack(side = BOTTOM)

def get_custom_image(label, imagePath):
    '''Function to get the selected image with the facial recognition algorithm'''

    custom_image_path = efr.show_image(imagePath)

    custom_image_variable = Image.open(custom_image_path)

    custom_image = ImageTk.PhotoImage(custom_image_variable)

    label.configure(image = custom_image)
    label.pack()
    label.image = custom_image
    