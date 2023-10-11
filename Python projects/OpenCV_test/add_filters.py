'''
    This python file is for the functions to add filters to the face
'''

import cv2
#import eye_and_face_recognition as efr    # For the functions
import numpy as np

# Variables
glasses = cv2.imread('./filters/Eye filters/png_glasses_31185.png')
print(glasses)

# Functions
def add_glasses(eyeX, eyeY, eyeWeight, eyeHeight, frame, img):
    '''Function to add the filter of glasses'''
    global glasses

    #glasses = cv2.resize(glasses, (eyeX + eyeWeight, eyeY + eyeHeight))    # First we reshape the size of the filter to adjust to the image

    for i in range(eyeHeight):
        for j in range(eyeWeight):
            for k in range(3):
                if (glasses[i, j, k] < 235):
                    img[eyeY + i - int(-0.20 * eyeHeight)][eyeX + j][k] = glasses[i, j, k]
                

    cv2.imshow(frame, img)

    cv2.waitKey(0)

    cv2.destroyAllWindows()  

    