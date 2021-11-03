#!/usr/bin/env python3

from manic import ManicMinerFile

if __name__ == '__main__':

    manic_file = ManicMinerFile()

    for room in manic_file.rooms:
        print(room.name)
