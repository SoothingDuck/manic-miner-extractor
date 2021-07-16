
from PIL import Image
import struct

def manic_miner_get_color(color_number):

    hash_color = {
        0 : (0,0,0), # black 
        1 : (0,0,255), # blue 
        10 : (255,0,0), # red
        11 : (255,0,255), # magenta 
        100 : (0,255,0), # green 
        101 : (0,255,255), # cyan
        110 : (255,255,0), # yellow
        111 : (255,255,255), # white
    }
    return hash_color[color_number]

def manic_miner_convert_byte_to_binary_string(byte):
    if isinstance(byte, int):
        tmp = hex(byte)
    else:
        tmp = byte.hex()

    str_binary = "%08d" % (int(bin(int(tmp, 16))[2:]))
    return(str_binary)

def manic_miner_color_struct(color_byte):
    tmp = manic_miner_convert_byte_to_binary_string(color_byte)
    flash = int(tmp[0])
    brightness = int(tmp[1])
    paper_colour = int(tmp[2:5])
    ink_colour = int(tmp[5:8])

    return(flash, brightness, manic_miner_get_color(paper_colour), manic_miner_get_color(ink_colour))

f = open("Manic Miner.tzx", "rb")

offset = int("33B4", 16) + 32 + 1 + 8 + 9 + 9 + 9 + 9 + 9 + 9 + 9

f.seek(offset)
color = f.read(1)
block = f.read(8)

flash, brightness, background_color, ink_color = manic_miner_color_struct(color)
img = Image.new("RGB", (8, 8), color = background_color)
pixels = img.load()
for j, b in enumerate(block):
    for i, f in enumerate(manic_miner_convert_byte_to_binary_string(b)):
        if f == "1":
            pixels[i, j] = ink_color

img.save("toto.png")