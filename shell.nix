{
  pkgs ? import <nixpkgs> { },
}:
let
  gradle = pkgs.gradle_9;
  jdk = pkgs.zulu25;
in
pkgs.mkShell {
  env = {
    JAVA_HOME = "${jdk.home}";
    GRADLE_HOME = "${gradle}";
  };
  
  packages = [
    pkgs.jre25_minimal
    jdk
    gradle
    pkgs.nixd
    pkgs.glib
    pkgs.google-java-format
  ];
}
