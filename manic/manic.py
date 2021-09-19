#!/usr/bin/env python3
import os
import bitarray

class ManicMinerColorAttribute():

    # A colour-attribute is represented as an 8-bit word in the following format (see Appendix D):
    # FBPPPIII
    # where:
    # F represents flash (0=not flashing, 1=flashing);
    # B represents brightness (0=not bright, 1=bright);
    # PPP represents paper colour (000=black, 001=blue, 010=red, 011=magenta, 100=green, 101=cyan, 110=yellow, 111=white);
    # III represents ink colour (as above).

    def __init__(self, character):
        self._character = character

class ManicMinerRoomLayout():

    def __init__(self, buffer):
        self._buffer = buffer

    @property
    def colors(self):
        result = []
        for i in range(16):
            result.append(self._buffer[(i*32):((i+1)*32)])
        return(result)


class ManicMinerRoom():

    MAGIC_OFFSET_SCREEN_LAYOUT = 0
    MAGIC_OFFSET_ROOM_NAME = 512

    def __init__(self, buffer):
        self._buffer = buffer

    @property
    def name(self):
        return self._buffer[ManicMinerRoom.MAGIC_OFFSET_ROOM_NAME:(ManicMinerRoom.MAGIC_OFFSET_ROOM_NAME+32)].strip().decode("utf8")

    @property
    def layout(self):
        return ManicMinerRoomLayout(self._buffer[ManicMinerRoom.MAGIC_OFFSET_SCREEN_LAYOUT:(ManicMinerRoom.MAGIC_OFFSET_SCREEN_LAYOUT+512)])

class ManicMinerFile():

    MAGIC_OFFSET_CENTRAL_CAVERN = int("33B4", 16) - 512

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
