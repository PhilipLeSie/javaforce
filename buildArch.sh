function build {
  ant jar
  sudo ant install
  ant pac -Darch=$1 -Darchext=$2
}

if [ "$1" == "" ]; then
  echo usage : buildArch.sh {ARCH}
  echo where ARCH=x32,x64,a32,a64
  exit
fi

ARCH=$1

case $1 in
x32)
  ARCHEXT=i686
  ;;
x64)
  ARCHEXT=x86_64
  ;;
a32)
  ARCHEXT=arm
  ;;
a64)
  ARCHEXT=aarch64
  ;;
*)
  echo Invalid arch!
  exit
  ;;
esac

build $ARCH $ARCHEXT
