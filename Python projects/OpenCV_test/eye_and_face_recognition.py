import matplotlib.pyplot as plt
import cv2
import add_filters as af
import picture_management as pm

def show_image(imagePath):
    '''Shows the selected image with the facial recognition algorithm'''

    face_cascade = cv2.CascadeClassifier("haarcascade_frontalface_default.xml")    # Detects the face

    eye_cascade = cv2.CascadeClassifier("frontalEyes35x16.xml")    # Detects the eyes

    img = plt.imread(imagePath)    # Reads the image path (uses matplotlib instead of opencv because opencv sucks with absolute pathing)

    img.shape

    img1 = img.copy()    # Makes a copy of the image. This is the one that will be modified with filters

    gray_frame = cv2.cvtColor(img, cv2.COLOR_BGR2GRAY)    # Makes the image grayscale for better face detection

    faces = face_cascade.detectMultiScale(gray_frame, 1.3, 5)    # Detect the face first. This returns a matrix of faces

    for (faceX, faceY, faceWeight, faceHeight) in faces:        
        cv2.rectangle(img, (faceX, faceY), (faceX + faceWeight, faceY + faceHeight), (255, 255, 0), 2)    # Draw a rectangle around the face 

        roi_gray = gray_frame[faceY: faceY + faceHeight, faceX: faceX + faceWeight]
                
        roi_color = img[faceY: faceY + faceHeight, faceX: faceX + faceWeight]
            
        eyes = eye_cascade.detectMultiScale(roi_gray)    # Detect eyes within the grayscale "region of interest"; AKA the faces

        for (eyeX, eyeY, eyeWeight, eyeHeight) in eyes:
            # Draws a rectangle on the eyes
            cv2.rectangle(roi_color, (eyeX, eyeY), (eyeX + eyeWeight, eyeY + eyeHeight), (0, 127, 255), 2)

        complete_path = pm.save_picture(img)

        return complete_path

        #af.add_glasses(eyeX, eyeY, eyeWeight, eyeHeight, window_name, img1)