'''All the function for the saving of pictures, image that has gone through the facial recognition algorithm, etc'''

import cv2
import matplotlib.pyplot as plt
import random
import string

def name_generator(size = 10, chars = string.ascii_uppercase + string.digits):
    '''Creates a randomly generated name'''
    
    return ''.join(random.choice(chars) for _ in range(size))

def save_picture(img):
    '''Saves the image in the "Saved pictures" folder'''

    complete_path = get_complete_path()

    plt.imsave(complete_path, img)

    return complete_path

def get_complete_path():
    '''Returns the complete path of the picture/image, with a randomly generated name'''

    path = "./Saved pictures"

    randomString = name_generator()

    pictureName = randomString + ".jpg"

    complete_path = path + "/" + pictureName

    return complete_path

def take_picture():
    '''Saves the first frame of the video as an image file'''

    videoCaptureObject = cv2.VideoCapture(0)

    path = get_complete_path()

    control = 0

    frame = None
	
	# For rapid fire option:
	'''
		while (control < 21):
			ret, frame = videoCaptureObject.read()
			
			if control > 10:
				cv2.imwrite(path, frame)

			control += 1

		Obviously, the "cv2.imwrite(path, frame)" outside the while has to be in commentary
	'''

    while(control < 10):    # Waits a small delay to make sure the picture is taken correctly
        ret, frame = videoCaptureObject.read()

        control += 1

    cv2.imwrite(path, frame)

    videoCaptureObject.release()
    
    cv2.destroyAllWindows()