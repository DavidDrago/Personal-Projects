import pygame, sys
from pygame.locals import *
import numpy as np
import keras
from keras.models import load_model
import cv2

windowSizeX = 640
windowSizeY = 480

boundary = 5

white = (255, 255, 255)
black = (0, 0, 0)
red = (255, 0, 0)

imageSave = False

MODEL = load_model("bestModel.keras")

labels = {0:"Zero", 1:"One", 2:"Two", 3:"Three", 4:"Four", 5:"Five", 6:"Six", 7:"Seven", 8:"Eight", 9:"Nine"}

# initialize the pygame
pygame.init()

font = pygame.font.SysFont("freesansbold.tff", 18)
displaySurf = pygame.display.set_mode((windowSizeX, windowSizeY))
pygame.display.set_caption("Digit Recognition")
displaySurf.fill(black)

iswriting = False

number_xcord = []
number_ycord = []

img_cnt = 1

predict = True

while True:
    for event in pygame.event.get():        
        if(event.type == QUIT):
            pygame.quit()
            sys.exit()

        if(event.type == KEYDOWN):
            if event.key == K_n:
                print("ket n is pressed")
                displaySurf.fill(black)

        if event.type == MOUSEMOTION and iswriting:
            xcord, ycord = event.pos
            pygame.draw.circle(displaySurf, white, (xcord, ycord), 4)
            
            number_xcord.append(xcord)
            number_ycord.append(ycord)


        if event.type == MOUSEBUTTONDOWN:
            print("Started drawing")
            iswriting = True

        if event.type == MOUSEBUTTONUP:
            print("digit is drawn")
            iswriting = False
            number_xcord = sorted(number_xcord)
            number_ycord = sorted(number_ycord)
            
            rect_min_x, rect_max_x = max(number_xcord[0]-boundary, 0), min(windowSizeX, number_xcord[-1]+boundary)
            rect_min_y, rect_max_y = max(number_ycord[0]-boundary, 0), min(windowSizeY, number_ycord[-1]+boundary)
        
            number_xcord = []
            number_ycord = []

            img_arr = np.array(pygame.PixelArray(displaySurf))[rect_min_x:rect_max_x, rect_min_y:rect_max_y].T.astype(np.float32)

            if imageSave:
                cv2.imwrite("image.png")
                img_cnt += 1

            if predict:
                #image = cv2.cvtColor(img_arr, cv2.COLOR_BGR2GRAY)
                #image = cv2.resize(img_arr, (28, 28), interpolation = cv2.INTER_AREA)
                #image = keras.utils.normalize(image, axis = 1) 
                image = cv2.resize(img_arr, (28, 28))
                image = np.pad(image, (10, 10), 'constant', constant_values=0)
                image = cv2.resize(image, (28, 28))/255

                label = str(labels[np.argmax(MODEL.predict(image.reshape(1, 28, 28, 1)))])
                textSurface = font.render(label,  True, red, white)
                textSurface = font.render(label, True, red, white)
                textRectObj = textSurface.get_rect()
                textRectObj.left, textRectObj.bottom = rect_min_x, rect_max_y

                displaySurf.blit(textSurface, textRectObj)

        pygame.display.update()