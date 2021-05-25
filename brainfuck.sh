#!/bin/bash


if [[ $# == 0 ]]
then
    javac Brainfuckcli.java && java Brainfuckcli
elif [[ $1 == "-gen" ]]
then
    javac GenBrainfuck.java && java GenBrainfuck $2
else 
    if [[ $1 == *.bf ]]
    then
        ((NUM = $(grep "" -c $1)))
        javac Brainfuckfile.java && java Brainfuckfile $NUM $2 <$1
    else
        echo "Invalid file! Brainfuck file should end with .bf extension"
    fi
fi
 
