#!/usr/bin/env python3
import os

class ManicMinerRoom():
    def __init__(self, buffer):
        self._buffer = buffer

    @property
    def name(self):
        return self._buffer[:32].strip().decode("utf8")

class ManicMinerFile():

    MAGIC_OFFSET_CENTRAL_CAVERN = int("33B4", 16)

    def __init__(self):
        self._filename = os.path.join("manic", "data", "Manic Miner.tzx")
        self._file = open(self._filename, "rb")

    @property
    def filename(self):
        return self._filename


    @property
    def rooms(self):
        self._file.seek(ManicMinerFile.MAGIC_OFFSET_CENTRAL_CAVERN)
        for i in range(20):
            buffer = self._file.read(1024)
            yield ManicMinerRoom(buffer)
