num = int(input('Digite um numero inteiro para a conversão: '))
print(''' Escolha uma das bases para a conversão: 
[ 1 ] conversão para BINÁRIO :
[ 2 ] conversão para OCTAL :
[ 3 ]  conversão para HEXADECIMAL : ''')
opção = (int(input('Sua opção :')))
if opção == 1:
    print('{} convertido para BINÁRIO é igual a {}'.format(num, bin(num)[2:]))
elif opção == 2:
    print('{} convertido para OCTAL é igual a {}'.format(num, oct(num)[2:]))
elif opção == 3:
    print('{} convertido para HEXADECIMAL é igual a {}'.format(num, hex(num)[2:]))
else:
    print('Opção inválida . TENTE NOVAMENTE ')
