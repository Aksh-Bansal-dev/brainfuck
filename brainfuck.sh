#!/bin/bash


if [[ $# -eq 0 ]]
then
    javac Brainfuckcli.java && java Brainfuckcli

else 
    if [[ $1 == *.bf ]]
    then
        ((NUM = $(grep "" -c $1)))
        javac Brainfuckfile.java && java Brainfuckfile $NUM <$1
    else
        echo "Invalid file! Brainfuck file should end with .bf extension"
    fi
fi
 
