def check_commas(author):
    '''Check if there are more than one author of a book. 
    If that's the case, split the authors into a list and then returns it'''
    
    if ',' in author:
        authors = author.split(',')

        return authors

    else:
        return False