import lexer
import miParse

lineasArchivo=[] #obtain each one of the lines of the file
lineasTokens=[]
tokens=[]





def main():
    lectura(lineasArchivo)
    lineasTokens = lexer.lex(lineasArchivo,tokens)
    print(lineasTokens)
    #print(lineasArchivo)
    #print(lineasTokens)
    miParse.parse(lineasTokens)



# read the file prueba.txt and save in a list
def lectura(lineasArchivo):
    with open('prueba.txt') as archivo:
        for linea in archivo:
            lineasArchivo.append(linea.rstrip())
    return

main()