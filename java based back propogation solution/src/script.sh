#!/bin/sh
javac Main.java
java Main
cd data
python test.py
cd ..
