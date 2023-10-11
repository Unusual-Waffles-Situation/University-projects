import csv
import psycopg2
from psycopg2 import Error
import checkMultipleAuthors as cma

with open('books_cleaned.csv', newline = '') as csvfile:
    spamreader = csv.reader(csvfile, delimiter = ',', doublequote = False, escapechar='|')    # Read the csv file
    
    checkFirst = False

    autoIncrement = 1

    try:
        # Connect to an existing database
        connection = psycopg2.connect(user="",
                                password="",
                                host="",
                                port="",
                                database="")

        # Create a cursor to perform database operations
        cursor = connection.cursor()

        #cursorForAuthors = connection.cursor()

        for row in spamreader:
            if checkFirst == False:
                checkFirst = True    # Ignores the variables name (AKA, the first row)

            else:
                isbnVariable = row[0]

                titleVaribale = row[1]

                authorVariable = row[2]

                yearVariable = row[3]
    
                insertQuery = """ INSERT INTO books (isbn, title, author, year) VALUES (%s, %s, %s, %s) """

                recordToInsert = (isbnVariable, titleVaribale, authorVariable, yearVariable)

                cursor.execute(insertQuery, recordToInsert)
    
                connection.commit()

                comprobationForMultiplesAuthors = cma.check_commas(authorVariable)

                if comprobationForMultiplesAuthors == False:
                    newQuery = """ INSERT INTO authors (idbook, name) VALUES (%s, %s) """

                    values = (autoIncrement, authorVariable)

                    cursor.execute(newQuery, values)

                    connection.commit()

                else:
                    authors = comprobationForMultiplesAuthors

                    numberOfAuthors = len(authors)

                    for i in range(numberOfAuthors):
                        newQuery = """ INSERT INTO authors (idbook, name) VALUES (%s, %s) """

                        values = (autoIncrement, authors[i])

                        cursor.execute(newQuery, values)

                        connection.commit()

                autoIncrement += 1
                
    except (Exception, Error) as error:
        print("Error while connecting to PostgreSQL", error)

    finally:
        if (connection):
            cursor.close()
            connection.close()
            print("PostgreSQL connection is closed")
    