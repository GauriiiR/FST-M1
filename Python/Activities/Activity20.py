# Import pandas
import pandas

dataframe = pandas.read_excel('sample.xlsx')

print(dataframe)

print("Number of rows and columns:", dataframe.shape)

print("Emails:")
print(dataframe['Email'])

print("Sorted data:")
print(dataframe.sort_values('FirstName'))