#!/usr/bin/env python
# -*- coding: utf-8 -*-

# Las dos líneas siguientes son necesaias para hacer 
# compatible el interfaz Tkinter con los programas basados 
# en versiones anteriores a la 8.5, con las más recientes. 

from tkinter import Tk    # Carga módulo tk (widgets estándar)  # Carga ttk (para widgets nuevos 8.5+)
from tkinter import Button
from tkinter import BOTTOM
from tkinter import Label
from tkinter import Entry
from tkinter import LEFT
from tkinter import Radiobutton
from tkinter import StringVar
from tkinter import Checkbutton
from tkinter import IntVar
from tkinter import DoubleVar
from tkinter import Scale
from tkinter import HORIZONTAL
from tkinter import END
from tkinter import ttk
from tkinter import scrolledtext
import tkinter as tk
from Encuesta_class import Encuesta 
from GestionadorPreguntas import GestionadorPreguntas
from string import Template
import json
from json import JSONDecoder
#from tkinter import Frame

# Define la ventana principal de la aplicación

mainFrame = Tk()

test_frame = Tk()
test_frame.state("withdrawn")

# Variables

sexoSV = StringVar() 
opcionSV = StringVar()
opcionResp = StringVar()
salarioDV = DoubleVar()
edadDV = DoubleVar()
sumJSON = 0

rbOption = ""
umbral = 50

JSON_FILENAME = 'Preguntas_Generales.json'

JSON_FILENAME_ESP = 'Preguntas_Especificas.json'

fileName = 'sample.json'

e = Encuesta(JSON_FILENAME, umbral)

eEsp = Encuesta(JSON_FILENAME_ESP, umbral)

formacionList = list()
nivel_exp_laboralList = list()
con_tec_genList = list()
mod_trabajoList = list()
idiomaList = list()
valList = list()
JSONlist = list()
RBOpcionesList = list()
preguntasList = list()
respuestasList = list()
catAceptadasList = list()
catAceptadasFinalList = []

preguntasList, respuestasList = e.obtenerPreguntasYRespuestas()


class Participant:
    def __init__(self, name, surname, age, gender, formation, labXP, genKnow, salary, travel, workMod, lan):
        self.name = name
        self.surname = surname
        self.age = age
        self.gender = gender
        self.formation = formation
        self.labXP = labXP
        self.genKnow = genKnow
        self.salary = salary
        self.travel = travel
        self.workMod = workMod
        self.lan = lan

class CounterCat:
    def __init__(self, count):
        self.count = count

class OpcionSexo:
    def __init__(self, genero):
        self.genero = genero

class OpcionViaje:
    def __init__(self, opcion):
        self.opcion = opcion

sexoObjeto = OpcionSexo(rbOption)
opcionObjeto = OpcionViaje(rbOption)

# Functions

def opcionSeleccionadaSexoM():
    sexoObjeto.genero = "M"

def opcionSeleccionadaSexoF():
    sexoObjeto.genero = "F"

def opcionSeleccionadaViajeSi():
    opcionObjeto.opcion = "Si"

def opcionSeleccionadaViajeNo():
    opcionObjeto.opcion = "No"

def opcionRespuestaOne(cat, frameN, auxVar, contPregAux, catCont):
    value = 1

    e.aumentarContPorCategoria(cat, contPregAux, value)

    deleteFrames(frameN, auxVar, contPregAux, catCont)

def opcionRespuestaTwo(cat, frameN, auxVar, contPregAux, catCont):
    value = 2
    
    e.aumentarContPorCategoria(cat, contPregAux, value)

    deleteFrames(frameN, auxVar, contPregAux, catCont)

def opcionRespuestaThree(cat, frameN, auxVar, contPregAux, catCont):
    value = 3
    
    e.aumentarContPorCategoria(cat, contPregAux, value)

    deleteFrames(frameN, auxVar, contPregAux, catCont)

def opcionRespuestaFour(cat, frameN, auxVar, contPregAux, catCont):
    value = 4
    
    e.aumentarContPorCategoria(cat, contPregAux, value)

    deleteFrames(frameN, auxVar, contPregAux, catCont)

def stageThreeRespuestaOne(frameN, index, indexResp, length, preguntas, respuestas, indexAux, cat, lenList, catAcep):
    value = 0

    catEsp = cat[indexAux]

    if eEsp.preguntas.compararRespuestaCorrecta(catEsp, index, value):
        index += 1

        stageThreeTestQuestions(frameN, index, indexResp, length, preguntas, respuestas, indexAux, cat, lenList, catAcep)

    else:
        frameN.destroy()

        indexAux += 1

        stageThreeTest(cat, indexAux, lenList, catAcep)

def stageThreeRespuestaTwo(frameN, index, indexResp, length, preguntas, respuestas, indexAux, cat, lenList, catAcep):
    value = 1

    catEsp = cat[indexAux]

    if eEsp.preguntas.compararRespuestaCorrecta(catEsp, index, value):
        index += 1

        stageThreeTestQuestions(frameN, index, indexResp, length, preguntas, respuestas, indexAux, cat, lenList, catAcep)

    else:
        frameN.destroy()

        indexAux += 1

        stageThreeTest(cat, indexAux, lenList, catAcep)

def stageThreeRespuestaThree(frameN, index, indexResp, length, preguntas, respuestas, indexAux, cat, lenList, catAcep):
    value = 2

    catEsp = cat[indexAux]

    if eEsp.preguntas.compararRespuestaCorrecta(catEsp, index, value):
        index += 1

        stageThreeTestQuestions(frameN, index, indexResp, length, preguntas, respuestas, indexAux, cat, lenList, catAcep)

    else:
        frameN.destroy()

        indexAux += 1

        stageThreeTest(cat, indexAux, lenList, catAcep)

def stageThreeRespuestaFour(frameN, index, indexResp, length, preguntas, respuestas, indexAux, cat, lenList, catAcep):
    value = 3

    catEsp = cat[indexAux]

    if eEsp.preguntas.compararRespuestaCorrecta(catEsp, index, value):
        index += 1

        stageThreeTestQuestions(frameN, index, indexResp, length, preguntas, respuestas, indexAux, cat, lenList, catAcep)

    else:
        frameN.destroy()

        indexAux += 1

        stageThreeTest(cat, indexAux, lenList, catAcep)


auxVar = 0
auxContPreg = 0
catCont = 0

contPreguntas = CounterCat(auxVar)
contRespuestas = CounterCat(auxVar)

# Segunda fase del test
def deleteFrames(frameN, auxVar, contPregAux, catCont):
    if auxVar < preguntasList.__len__():
        contPreg = contPreguntas.count
        counter = 4
        countPreg = contPregAux
        catContAux = catCont

        cat = ""

        dictionary = {}

        frameN.destroy()

        test_frame = Tk()

        test_frame.geometry('800x700')

        test_frame.title("Segunda fase")

        pregunta = ""
        pregunta = preguntasList[contPreg]

        contPreguntas.count += 1
    
        testL = Label(test_frame, text = pregunta)
        testL.place(x = 75, y = 51)

        yVal = 75

        for i in range (counter):
            contResp = contRespuestas.count
            respuesta = ""
            respuesta = respuestasList[contResp]

            valueVar = "" + str(i + 1)

            dictionary.setdefault(respuesta, valueVar)

            valRes = str(respuesta)

            contRespuestas.count += 1 

            cat = e.categorias[catContAux]

        auxVar += 1

        if countPreg == 1:
            countPreg = 0
            catContAux += 1

        else:
            countPreg = 1

        for (text, value) in dictionary.items():
            respuestaL = Label(test_frame, text = text)
            respuestaL.place(x = 225, y = yVal)

            yVal += 125

        yVal = 100

        botonRespOne = Button(test_frame, text = "Seleccionar opcion", command = lambda: opcionRespuestaOne(cat, test_frame, auxVar, countPreg, catContAux))
        botonRespOne.place(x = 225, y = yVal)

        yVal += 125

        botonRespOne = Button(test_frame, text = "Seleccionar opcion", command = lambda: opcionRespuestaTwo(cat, test_frame, auxVar, countPreg, catContAux))
        botonRespOne.place(x = 225, y = yVal)

        yVal += 125

        botonRespOne = Button(test_frame, text = "Seleccionar opcion", command = lambda: opcionRespuestaThree(cat, test_frame, auxVar, countPreg, catContAux))
        botonRespOne.place(x = 225, y = yVal)

        yVal += 125

        botonRespOne = Button(test_frame, text = "Seleccionar opcion", command = lambda: opcionRespuestaFour(cat, test_frame, auxVar, countPreg, catContAux))
        botonRespOne.place(x = 225, y = yVal)
    
    else:
        frameN.destroy()

        #test_frame = Tk()

        #test_frame.geometry('700x700')

        #test_frame.title("Pantalla de resultados")

        porcentajes = e.obtenerTodosPorcentajesCategorias()

        porcentajes = e.ordenarPorcentajesCategorias(porcentajes)

        catAceptadasList = e.obtenerCategoriasAceptadas(porcentajes)

        length = len(catAceptadasList)

        inAux = 0

        boolComp = False

        stageThreeTest(catAceptadasList, inAux, length, catAceptadasFinalList)

        #test_frameL = Label(test_frame, text = e.obtenerCategoriasAceptadas(porcentajes))
        #test_frameL.place(x = 0, y = 51)

        #test_framePorL = Label(test_frame, text = e.mostrarPorcentajesCategorias())
        #test_framePorL.place(x = 0, y = 200)

def stageThreeTest(cat, index, length, catAcep):
    if index < length:
        catAceptadasList = cat

        preguntasEspList = []

        respuestasEspList = []

        preguntasEspList = eEsp.preguntas.getPreguntasPorCategoria(catAceptadasList[index])

        lengthResp = len(preguntasEspList)

        respuestasEspList = eEsp.preguntas.getRespuestasPorCategoria(catAceptadasList[index])

        indexAux = 0

        indexResp = 0

        frameAux = Tk()

        frameAux.state("withdrawn")

        stageThreeTestQuestions(frameAux, indexAux, indexResp, lengthResp, preguntasEspList, respuestasEspList, index, catAceptadasList, length, catAcep)

    elif index == length and len(catAcep) > 0:
        stage_three_frame = Tk()

        stage_three_frame.geometry('700x700')

        stage_three_frame.title("Tercera fase")

        labelW = Label(stage_three_frame, text = "Usted ha pasado. Categoria aceptada(s):")
        labelW.place(x = 0, y = 51)

        yVal = 101

        for i in range(len(catAcep)):
            test_frameL = Label(stage_three_frame, text = catAcep[i])
            test_frameL.place(x = 0, y = yVal)

            yVal += 50

    elif index == length and len(catAcep) == 0:
        stage_three_frame = Tk()

        stage_three_frame.geometry('700x700')

        stage_three_frame.title("Tercera fase")

        labelW = Label(stage_three_frame, text = "Usted no ha pasado")
        labelW.place(x = 0, y = 51)

def stageThreeTestQuestions(frameN, index, indexResp, length, preguntas, respuestas, indexAux, cat, lenList, catAcep):
    if index < length:
        indexPreg = index

        indexRespAux = indexResp

        frameN.destroy()

        stage_three_frame = Tk()

        stage_three_frame.geometry('700x700')

        stage_three_frame.title("Tercera fase")

        text = preguntas[indexPreg]

        preguntaL = Label(stage_three_frame, text = text)

        preguntaL.place(x = 75, y = 51)

        count = 4

        yVal = 75

        yVal2 = 100

        for i in range (count):
            respuesta = respuestas[indexRespAux]

            respuestaL = Label(stage_three_frame, text = respuesta)
            respuestaL.place(x = 225, y = yVal)    

            yVal += 125

            indexRespAux += 1                

        botonRespOne = Button(stage_three_frame, text = "Seleccionar opcion", command = lambda: stageThreeRespuestaOne(stage_three_frame, indexPreg, indexRespAux, length, preguntas, respuestas, indexAux, cat, lenList, catAcep))
        botonRespOne.place(x = 225, y = yVal2)

        yVal2 += 125

        botonRespTwo = Button(stage_three_frame, text = "Seleccionar opcion", command = lambda: stageThreeRespuestaTwo(stage_three_frame, indexPreg, indexRespAux, length, preguntas, respuestas, indexAux, cat, lenList, catAcep))
        botonRespTwo.place(x = 225, y = yVal2)

        yVal2 += 125

        botonRespThree = Button(stage_three_frame, text = "Seleccionar opcion", command = lambda: stageThreeRespuestaThree(stage_three_frame, indexPreg, indexRespAux, length, preguntas, respuestas, indexAux, cat, lenList, catAcep))
        botonRespThree.place(x = 225, y = yVal2)

        yVal2 += 125

        botonRespFour = Button(stage_three_frame, text = "Seleccionar opcion", command = lambda: stageThreeRespuestaFour(stage_three_frame, indexPreg, indexRespAux, length, preguntas, respuestas, indexAux, cat, lenList, catAcep))
        botonRespFour.place(x = 225, y = yVal2)

    else:
        frameN.destroy()

        catAcep.append(cat[indexAux])

        indexAux += 1

        stageThreeTest(cat, indexAux, lenList, catAcep)

def closeWindows(window, window2):
    window.destroy()

    window2.destroy()

def writeToJSON(data):
    with open(fileName, "w") as f: 
        json.dump(data, f, indent = 11)

def isFileEmpty(file):
    if os.stat(file).st_size == 0:
        return True

    else:
        return False

def addToJSON(nameVar, surVar, ageVar, genderVar, formVar, labXPVar, genVar, salVar, travel, workVar, lan):
    with open ('sample.json') as json_file:

        data = json.load(json_file) 

        temp = data['Participante'] 

        y = {
            "Nombre": nameVar,
            "Apellido": surVar,
            "Edad": ageVar,
            "Sexo": genderVar,
            "Formacion": formVar,
            "Nivel de experiencia laboral": labXPVar,
            "Conocimientos tecnicos generales": genVar,
            "Aspiracion salarial": salVar,
            "Disponibilidad de viaje": travel,
            "Modalidad de trabajo": workVar,
            "Idioma": lan 
        }

        temp.append(y)


    writeToJSON(data)

def readJSON():
    key = "Participante"

    nameVar = ""
    surVar = ""
    ageVar = 0
    genderVar = ""
    formVar = ""
    labXPVar = ""
    genVar = ""
    salVar = 0
    travel = ""
    workVar = ""
    lan = ""

    with open('sample.json') as f:
        data = json.load(f)

    for i in data[key]:
        nameVar = i["Nombre"]
        surVar = i["Apellido"]
        ageVar = i["Edad"]
        genderVar = i["Sexo"]
        formVar = i["Formacion"]
        labXPVar = i["Nivel de experiencia laboral"]
        genVar = i["Conocimientos tecnicos generales"]
        salVar = i["Aspiracion salarial"]
        travel = i["Disponibilidad de viaje"]
        workVar = i["Modalidad de trabajo"]
        lan = i["Idioma"]

        addToJSONList(nameVar, surVar, ageVar, genderVar, formVar, labXPVar, genVar, salVar, travel, workVar, lan)

def addToJSONList(nameVar, surVar, ageVar, genderVar, formVar, labXPVar, genVar, salVar, travel, workVar, lan):
    p = Participant(nameVar, surVar, ageVar, genderVar, formVar, labXPVar, genVar, salVar, travel, workVar, lan)

    JSONlist.append(p)

# Primera fase de la prueba
def testWindow():
    raiz = Tk()

    raiz.geometry('450x700')

    raiz.title('Primera parte de la prueba')

    raiz.configure(bg = '#fffff5')

    # Combobox

    formacionCB = ttk.Combobox(raiz, state = "readonly")
    formacionCB.place(x = 95, y = 301)
    readJSONFor()
    formacionCB['values'] = formacionList

    nivel_exp_laboralCB = ttk.Combobox(raiz, state = "readonly")
    nivel_exp_laboralCB.place(x = 245, y = 401)
    readJSONCom()
    nivel_exp_laboralCB['values'] = nivel_exp_laboralList

    con_tec_genCB = ttk.Combobox(raiz, state = "readonly")
    con_tec_genCB.place(x = 205, y = 351)
    readJSONXP()
    con_tec_genCB['values'] = con_tec_genList

    mod_trabajoCB = ttk.Combobox(raiz, state = "readonly")
    mod_trabajoCB.place(x = 175, y = 551)
    readJSONMod()
    mod_trabajoCB['values'] = mod_trabajoList

    idiomaCB = ttk.Combobox(raiz, state = "readonly")
    idiomaCB.place(x = 65, y = 601)
    readJSONLan()
    idiomaCB['values'] = idiomaList

    #Labels
    
    datos_personalesL = Label(raiz, text = "Datos personales")
    datos_personalesL.place(x = 150, y = 1)
    
    nombreL = Label(raiz, text = "Nombre: ")
    nombreL.place(x = 0, y = 51)
    
    apellidoL = Label(raiz, text = "Apellido: ")
    apellidoL.place(x = 0, y = 101)
    
    edadL = Label(raiz, text = "Edad: ")
    edadL.place(x = 0, y = 151)
    
    sexoL = Label(raiz, text = "Sexo: ")
    sexoL.place(x = 0, y = 201)
    
    datos_tecnicosL = Label(raiz, text = "Datos técnicos")
    datos_tecnicosL.place(x = 150, y = 251)
    
    formacionL = Label(raiz, text = "Formación: ")
    formacionL.place(x = 0, y = 301)
    
    nivel_exp_laboralL = Label(raiz, text = "Nivel de experiencia laboral: ")
    nivel_exp_laboralL.place(x = 0, y = 351)
    
    conocimientos_tec_genL = Label(raiz, text = "Conocimientos técnicos generales: ")
    conocimientos_tec_genL.place(x = 0, y = 401)
    
    salarioL = Label(raiz, text = "Apiración salarial: ")
    salarioL.place(x = 0, y = 451)
    
    disp_viajeL = Label(raiz, text = "Disponibilidad de viaje: ")
    disp_viajeL.place(x = 0, y = 501)
    
    mod_trabajoL = Label(raiz, text = "Modalidad de trabajo: ")
    mod_trabajoL.place(x = 0, y = 551)
    
    idiomaL = Label(raiz, text = "Idioma: ")
    idiomaL.place(x = 0, y = 601)

    #Entries

    nombreE = Entry(raiz, bg = 'beige')
    nombreE.place(x = 75, y = 51)

    apellidoE = Entry(raiz, bg = 'beige')
    apellidoE.place(x = 77, y = 101)

    # Scale

    edadS = Scale(raiz, variable = edadDV, orient = HORIZONTAL, from_ = 18, to = 60)
    edadS.place(x = 55, y = 145)

    salarioS = Scale(raiz, variable = salarioDV, orient = HORIZONTAL, to = 5000)#, from_ = 20, to = 25)
    salarioS.place(x = 140, y = 445)

    #Button

    textOp = "M"
    sexoMBoton = Button(raiz, text = textOp, command = opcionSeleccionadaSexoM)
    sexoMBoton.place(x = 55, y = 201)

    textOp = "F"
    sexoFBoton = Button(raiz, text = textOp, command = opcionSeleccionadaSexoF)
    sexoFBoton.place(x = 105, y = 201)

    textOp = "Si"
    opcionPosViajeBoton = Button(raiz, text = textOp, command = opcionSeleccionadaViajeSi)
    opcionPosViajeBoton.place(x = 175, y = 501)

    textOp = "No"
    opcionNegViajeBoton = Button(raiz, text = textOp, command = opcionSeleccionadaViajeNo)
    opcionNegViajeBoton.place(x = 225, y = 501)

    #Button(raiz, text = "Next", command = getInfo).pack(side = BOTTOM)
    siguienteB = Button(raiz, text = "Next", command = lambda: getInfo(nombreE, apellidoE, edadS, salarioS, formacionCB, nivel_exp_laboralCB, con_tec_genCB, mod_trabajoCB, idiomaCB, raiz)).pack(side = BOTTOM)

    #raiz.mainloop()

# Muestra los candidatos aceptados
def showAcceptedCandidates():
    readJSON()

    candi_frame = Tk()
    candi_frame.geometry('400x700')

    candi_frame.title('Candidatos aceptados')

    text_area = scrolledtext.ScrolledText(candi_frame,  
                                      wrap = tk.WORD,  
                                      width = 40,  
                                      height = 70,  
                                      font = ("Times New Roman", 
                                              15)) 
  
    text_area.grid(column = 0, pady = 10, padx = 10) 
  
    # Placing cursor in the text area 
    text_area.focus() 

    size = len(JSONlist)

    for i in range(size):
        string = "Nombre: " + JSONlist[i].name + '\n'
        string += "Apellido: " + JSONlist[i].surname + "\n"
        string += "Edad: " + JSONlist[i].age + "\n"
        string += "Sexo: " + JSONlist[i].gender + "\n"
        string += "Formacion: " + JSONlist[i].formation + "\n"
        string += "Nivel de experiencia laboral: " + JSONlist[i].labXP + "\n"
        string += "Conocimientos tecnicos generales: " + JSONlist[i].genKnow + "\n"
        string += "Aspiracion salarial: " + JSONlist[i].salary + "\n"
        string += "Disponibilidad de viaje: " + JSONlist[i].travel + "\n"
        string += "Modalidad de trabajo: " + JSONlist[i].workMod + "\n"
        string += "Idioma: " + JSONlist[i].lan + "\n"

        text_area.insert(END, string + "\n")  

    text_area.configure(state ='disabled')

def secondStageTest(firstWindow, secondWindow, test_frame, auxVar, auxContPreg, catCont):
    closeWindows(firstWindow, secondWindow)

    deleteFrames(test_frame, auxVar, auxContPreg, catCont)

def getInfo(nombreE, apellidoE, edadS, salarioS, formacionCB, nivel_exp_laboralCB, con_tec_genCB, mod_trabajoCB, idiomaCB, raiz):
    second = Tk()
    second.geometry('400x700')

    second.title('Pantalla de verificación')

    # Nombre (0)

    valList.append(nombreE.get())
    nombreOpcion = str(nombreE.get())

    # Apellido (1)

    valList.append(apellidoE.get())
    apellidoOpcion = str(apellidoE.get())

    # Edad (2)
    
    edadOpcion = getScale(edadS)

    valList.append(edadOpcion)

    # Sexo (3)
    
    sexoOpcion = sexoObjeto.genero

    #sexoOpcion = getRBValue()

    valList.append(sexoOpcion)

    #Formación (4)
    
    formOpcion = getComboBoxValue(formacionCB)

    valList.append(formOpcion)

    #Años exp (5)
    
    expOpcion = getComboBoxValue(con_tec_genCB)

    valList.append(expOpcion)

    # Conocimientos (6)
    
    conOpcion = getComboBoxValue(nivel_exp_laboralCB)

    valList.append(conOpcion)

    # Salario (7)
    
    salOpcion = getScale(salarioS)

    valList.append(salOpcion)
    
    # Viaje (8)
    
    viajeOpcion = opcionObjeto.opcion

    #viajeOpcion = getRBValue2()

    valList.append(viajeOpcion)

    # Modalidad trabajo (9)
    
    trabaOpcion = getComboBoxValue(mod_trabajoCB)

    valList.append(trabaOpcion)

    # Idioma (10)
    
    idiomaOpcion = getComboBoxValue(idiomaCB)

    valList.append(idiomaOpcion)

    newSum = compareWithJSON()

    if compareTotalValue(newSum):
        Label13 = Label(second, text = "Usted ha clasificado")
        Label13.place(x = 0, y = 1)
        addToJSON(nombreOpcion, apellidoOpcion, edadOpcion, sexoOpcion, formOpcion, expOpcion, conOpcion, salOpcion, viajeOpcion, trabaOpcion, idiomaOpcion)
        Button(second, text = "Siguiente paso", command = lambda: secondStageTest(raiz, second, test_frame, auxVar, auxContPreg, catCont)).pack(side = BOTTOM)

    else:
        Label13 = Label(second, text = "Usted no ha clasificado")
        Label13.place(x = 0, y = 1)
        Button(second, text = "Salir", command = lambda: closeWindows(raiz, second)).pack(side = BOTTOM)

def getRBValue():
    rbOption = sexoSV.get() 

    return rbOption

def getRBValue2():
    rbOption = opcionSV.get()

    return rbOption

def getComboBoxValue(ComboVal):
    rbOption = "" + str(ComboVal.get())

    return rbOption

def getScale(scaleVal):
    rbOption = "" + str(scaleVal.get())

    return rbOption

def readJSONFor():
    with open('Base de Conocimiento.json') as json_file:
        data = json.load(json_file)

        #varY = 0

        for i in data['Formacion']:
            aux = i['nombre']
            formacionList.append(aux)

def readJSONCom():
    with open('Base de Conocimiento.json') as json_file:
        data = json.load(json_file)

        for i in data['Competencias']:
            aux = i['nombre']
            nivel_exp_laboralList.append(aux)

def readJSONXP():
    with open('Base de Conocimiento.json') as json_file:
        data = json.load(json_file)

        for i in data['Experiencia']:
            aux = i['nombre']
            con_tec_genList.append(aux)

def readJSONLan():
    with open('Base de Conocimiento.json') as json_file:
        data = json.load(json_file)

        for i in data['Idioma']:
            aux = i['nombre']
            idiomaList.append(aux)

def readJSONMod():
    with open('Base de Conocimiento.json') as json_file:
        data = json.load(json_file)

        for i in data['Modalidad de Trabajo']:
            aux = i['nombre']
            mod_trabajoList.append(aux)

def compareEdad(JSONData, item, pos):
    nombreTitle = "nombre"
    pointsTitle = "valor"
    edadTitle = "edad"
    minEdad, maxEdad, objEdad = {}, {}, {}
    for i in JSONData[item]:
        nombre = i[nombreTitle]
        edad = i[edadTitle]
        valor = i[pointsTitle]

        if nombre == "min":
            minEdad = {"edad": edad, "puntos": valor}
        elif nombre == "max":
            maxEdad = {"edad": edad, "puntos": valor}
        elif nombre == "obj":
            objEdad = {"edad": edad, "puntos": valor}

    edad = int(valList[pos])
    if edad == objEdad["edad"]:
        return objEdad["puntos"]
    elif edad == minEdad["edad"]:
        return minEdad["puntos"]
    elif edad == maxEdad["edad"]:
        return maxEdad["puntos"]
    elif edad < objEdad["edad"]:
        a = objEdad["edad"] - minEdad["edad"]
        b = objEdad["edad"] - edad
        c = objEdad["puntos"] - minEdad["puntos"]
        return objEdad['puntos'] - round(c * b / a)
    elif edad > objEdad["edad"]:
        a = maxEdad["edad"] - objEdad["edad"]
        b = maxEdad["edad"] - edad
        c = maxEdad["puntos"] - minEdad["puntos"]
        return maxEdad['puntos'] - round(c * b / a)
    return 0

# compare data from GUI to data from JSON
# needs Data from JSON, string of item to compare
# and index of the array to get GUI data
def compareCompetencias(JSONData, item, pos):
    nombreTitle = "nombre"
    pointsTitle = "valor"
    for i in JSONData[item]:
        nombre = i[nombreTitle]
        valor = i[pointsTitle]

        if valList[pos] == nombre:
            return valor
    return 0

def compareTotalValue(suma):
    with open('Base de Conocimiento.json') as json_file:
        data = json.load(json_file)

        for i in data['Puntaje minimo']:
            aux = i['valor']
            
            if suma >= aux:
                return True
            
            else:
                return False
    return 0

def compareWithJSON():
    # Load JSON

    suma = 0

    with open('Base de Conocimiento.json') as json_file:
        data = json.load(json_file)

        suma += compareCompetencias(data, "Idioma", 10)
        suma += compareCompetencias(data, "Modalidad de Trabajo", 9)
        suma += compareCompetencias(data, "Disponibilidad de Viaje", 8)
        # suma += compareCompetencias(data, "Salario", 7)
        suma += compareCompetencias(data, "Competencias", 6)
        suma += compareCompetencias(data, "Experiencia", 5)
        suma += compareCompetencias(data, "Formacion", 4)
        suma += compareCompetencias(data, "Sexo", 3)
        suma += compareEdad(data, "Edad", 2)

        '''for i in data['Competencias']:
            aux = i['nombre']
            points = i['valor']
            
            if valList[6] == aux:
                suma += points
        
        for i in data['Experiencia']:
            aux = i['nombre']
            points = i['valor']
            
            if valList[5] == aux:
                suma += points'''

    return suma

    # Get points associated with every item
    # Get points for every item selected in the GUI
    # Get avg.
    # Profit

# Buttons

tomar_testB = Button(mainFrame, text = "Tomar test", command = testWindow)
tomar_testB.place(x = 125, y = 550)

personas_aprobadasB = Button(mainFrame, text = "Ver personas clasificadas", command = showAcceptedCandidates)
personas_aprobadasB.place(x = 325, y = 550)

testB = Button(mainFrame, text = "Testo shimasho", command = lambda : deleteFrames(test_frame, auxVar, auxContPreg, catCont))
testB.place(x = 0, y = 51)

mainFrame.geometry('600x600')

mainFrame.title('Main')

mainFrame.mainloop()